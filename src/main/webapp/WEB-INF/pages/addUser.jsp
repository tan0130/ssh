<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="user" class="ssh.entity.User" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>My JSP 'addUser.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
<h1>添加用户</h1>
<sf:form action="/user/addUser" modelAttribute="user" method="post">
    姓名：<sf:input path="userName" name="userName" value="${user.userName } "/><font color="red"><sf:errors path="userName"/></font><br/>
    年龄：<sf:input path="age" value="${user.age } "/><font color="red"><sf:errors path="age"/></font><br/>
    <input type="submit" value="添加">
</sf:form>
</body>
</html>
