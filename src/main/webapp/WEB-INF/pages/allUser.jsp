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

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript" src="../../resources/js/jquery-1.10.2.js"></script>
    <script type="text/javascript">
        function del(id){
            /* $.get("/springmvc/user/delUser?id=" + id,function(data){
                if("success" == data.result){
                    alert("删除成功");
                    window.location.reload();
                }else{
                    alert("删除失败");
                }
            }); */
            var msg = "删除后将不能恢复，确认删除【"+id+" 】吗？";
            if(confirm(msg) == true) {
               /* window.location.href = "/springmvc/user/delUser?id=" + id;
                if("success") {
                    alert("删除成功！");
                } else {
                    alert("删除失败！");

                }*/
               $.ajax({
                   type: 'get',
                   asunc: false,
                   cache: false,
                   url: '/user/delUser',
                   data: {
                       id: id
                   },
                   success:function(data) {
                       if(data == "success") {
                           alert("删除成功");
                       } else {
                           alert("删除失败");
                       }
                   },
                   error:function(data) {
                       alert("删除失败");
                   }
               });
            } else {

            }
        }
    </script>
</head>

<body>
<h6><a href="/user/toAddUser">添加用户</a></h6>
<table border="1">
    <tbody>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <c:if test="${!empty userList }">
        <c:forEach items="${userList }" var="user">
            <tr>
                <td>${user.id }</td>
                <td>${user.userName }</td>
                <td>${user.age }</td>
                <td>
                    <a href="/user/getUser?id=${user.id }">编辑</a>
                    <a href="javascript:del('${user.id }')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
