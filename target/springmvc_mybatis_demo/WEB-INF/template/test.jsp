
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<body>
<h2>Hello test! in web-inf</h2>
<%= (String) request.getAttribute("key")%>
姓名：${key}
<input type="button" value="${key}" id="method1">
</body>
</html>
