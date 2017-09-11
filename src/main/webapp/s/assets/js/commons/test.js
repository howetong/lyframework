	//修改个人资料
	function editUserH(){
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="个人资料";
		 diag.URL = locat+'/user/goEditU.do?USER_ID='+USER_ID+'&fx=head';
		 diag.Width = 225;
		 diag.Height = 389;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
	}


	//菜单
	function menu(){
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="菜单编辑";
		 diag.URL = locat+'/menu.do';
		 diag.Width = 720;
		 diag.Height = 390;
		 diag.CancelEvent = function(){ //关闭事件
			diag.close();
		 };
		 diag.show();
		 
	}


	//清除
	function htmlReload(){
		$("#json-field").html("");
		//self.location.reload();
	}
	//重置
	function gReload(){
		$("#serverUrl").val('');
		$("#json-field").html('');
		//self.location.reload();
	}

	//请求类型
	function setType(value){
		$("#S_TYPE").val(value);
	}
	function sendSever(){
		
		if($("#serverUrl").val()==""){
			$("#serverUrl").tips({
				side:3,
				msg:'输入请求地址',
				bg:'#AE81FF',
				time:2
			});
			$("#serverUrl").focus();
			return false;
		}
		var type = $("#S_TYPE").val();
		
		var url = $("#serverUrl").val();
		var data = {};
		var contentType = "application/json;charset=UTF-8";
		if(type == "PUT"){
			data.id = 1;
		}
		if(type == "GET" || type == "DELETE"){
			data = null;
			contentType = null;
		}else{
			XY.Util.cpObj(data,XY.Util.Url.getParameter(url))
			data = JSON.stringify(data);
			url = XY.Util.Url.getPath(url);
		}
		
		
		console.log(data);
		$.ajax({
			"contentType":contentType,
			"dataType":"json",
			type: type,
			url: url,
			data: data,
			cache: false,
			success: function(data){
				var jsondata = JSON.stringify(data.result || data);
				$("#json-field").html(jsondata);
				$("#json-field").tips({
					side:2,
					msg:'返回结果',
					bg:'#75C117',
					time:10
				});
				console.log(data);
				//hljs.configure({tabReplace:'    ',classPrefix:''})
				//hljs.registerLanguage("json");
				hljs.initHighlighting();
			}
		});
	}

	function intfBox(){
		var intfB = document.getElementById("json-field");
		var intfBt = document.documentElement.clientHeight;
		
		intfB.style.height = (intfBt  - 560) + 'px';
	}
	intfBox();
	//js  日期格式
	//date2str(new Date(),"yyyyMMdd")
	function date2str(x,y) {
		var z ={y:x.getFullYear(),M:x.getMonth()+1,d:x.getDate(),h:x.getHours(),m:x.getMinutes(),s:x.getSeconds()};
		return y.replace(/(y+|M+|d+|h+|m+|s+)/g,function(v) {return ((v.length>1?"0":"")+eval('z.'+v.slice(-1))).slice(-(v.length>2?v.length:2))});
	};