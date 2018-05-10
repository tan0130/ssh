<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'editUser.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript" src="../../resources/js/jquery-1.10.2.js"></script>
</head>
<script type="text/javascript">
</script>
<body>
<h1>编辑用户</h1>
<form action="/user/updateUser" name="userForm" method="post">
    <input type="hidden" name="id" value="${user.id }">
    姓名：<input type="text" name="userName" value="${user.userName }">
    年龄：<input type="text" name="age" value="${user.age }">
    <input type="submit" value="编辑" >
</form>
</body>
</html>
