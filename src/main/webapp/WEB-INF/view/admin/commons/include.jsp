<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<%=basePath%>s/assets/js/commons/Th.js"></script>
<script type="text/javascript" src="<%=basePath%>s/assets/js/commons/index.js"></script>

<script>
    var app = TH.Util.app = new App();
    app.init();
    app.contentPath = ""+"<%=basePath%>";
    app.mainPath = ""+"${mainPath}";
    app.loginPath = ""+"${loginPath}";
    app.rootPath = ""+"${basePath}";
</script>

<script type="text/javascript" src="<%=basePath%>s/assets/js/commons/dtExtend.js"></script>
<script type="text/javascript" src="<%=basePath%>s/assets/js/commons/FormSample.js"></script>