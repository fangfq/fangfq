<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    
    <title>My JSP 'Welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/fangfq/layui/css/layui.css">
	<script src="/fangfq/layui/layui.all.js"></script>
	<script type="text/javascript">
		function test(){
			layer.msg('hello');
		}
	</script>
  </head>
  <body>
  ${itemList }
	<button onclick="test()">弹框提示</button>
    This is my JSP page. <br>
  </body>
</html>
