<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../commons/commons.jsp"%>
<title>连接测试</title>
<link rel="stylesheet" href="<%=basePath%>s/codestyle/prism/prism.css"/>
<link rel="stylesheet" href="<%=basePath%>s/codestyle/highlight/styles/monokai-sublime.css"/>
<div class="row">
 	<div class="col-sm-12 col-xs-12">
		<div class="widget-box">
			<div class="widget-header widget-header-blue widget-header-flat wi1dget-header-large">
				<h4 class="lighter">服务器接口测试</h4>
			</div>
			<div class="widget-body">
			 <div class="widget-main form-horizontal">
				<div class="form-group">
					<div class="col-sm-12">
						<div class="col-sm-10">
							<span class="input-icon  col-sm-12">
								<input type="text" id="serverUrl" title="输入请求地址" value="<%=basePath%>admin/menu/tree/0/get.do" class="width-100">
							</span>
						</div>
						
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12 radio control-group">
						<label class="col-lg-offset-1 ">
							<input name="form-field-radio1" id="form-field-radio1" onclick="setType('GET');" type="radio" value="icon-edit"><span class="lbl">GET</span>
						</label>
						<label class="col-lg-offset-1">
							<input name="form-field-radio1" id="form-field-radio2" onclick="setType('PUT');" type="radio" value="icon-edit"><span class="lbl">PUT</span>
						</label>
						<label class="col-lg-offset-1">
							<input name="form-field-radio1" id="form-field-radio3" onclick="setType('POST');" type="radio" value="icon-edit" checked="checked"><span class="lbl">POST</span>
						</label>
						<label class="col-lg-offset-1">
							<input name="form-field-radio1" id="form-field-radio4" onclick="setType('DELETE');" type="radio" value="icon-edit"><span class="lbl">DELETE</span>
						</label>
						<label class="col-lg-offset-1">
							&nbsp;&nbsp;<a class="btn btn-sm btn-success" onclick="sendSever();">请求</a>
							&nbsp;&nbsp;<a class="btn btn-sm btn-info" onclick="gReload();">重置</a>
							&nbsp;&nbsp;<a class="btn btn-sm btn-primary" onclick="htmlReload();">清除数据</a>
						</label>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<span class="input-icon col-sm-12">
						<pre style="padding: 0;
									margin: 0;
									line-height: 20px;
									overflow: auto;
									overflow-y: hidden;
									white-space: pre-line;
									word-wrap: break-word;">
							<code id="json-field" class="js languages-json col-xs-12 col-sm-12">
									
							</code>
						</pre>
						</span>
					</div>
				</div>
				<div class="form-group">
				<label style="float:left;padding-left: 35px;">服务器响应：<font color="red" id="stime">-</font>&nbsp;毫秒</label>
				<label style="float:left;padding-left: 35px;">客户端请求：<font color="red" id="ctime">-</font>&nbsp;毫秒</label>
				</div>	
				 <input type="hidden" name="S_TYPE" id="S_TYPE" value="POST"/>
				 
			 </div><!--/widget-main-->
			</div><!--/widget-body-->
		</div>
	</div> 
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
<script type="text/javascript">
	var scripts = [null,
	"<%=basePath%>s/assets/js/ace/ace-elements.min.js",
	"<%=basePath%>s/assets/js/jquery.md5.js",
	"<%=basePath%>s/assets/js/jquery.tips.js",
	"<%=basePath%>s/assets/js/commons/test.js",
	//"<%=basePath%>s/codestyle/prism/prism.js",
	"<%=basePath%>s/codestyle/highlight/highlight.pack.js",
	null]
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		
	});
</script>