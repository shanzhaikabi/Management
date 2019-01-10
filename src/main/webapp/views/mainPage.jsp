<%--
  Created by IntelliJ IDEA.
  User: Shanzhai
  Date: 2018-12-12
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="GET">
    当前用户 : ${user.name}
    <form action="${pageContext.request.contextPath}/login" method="GET">
        <label class="block clearfix">
            登陆
        </label>
        <input type="submit" value="前往" style="width:100px;">
    </form>
    <form action="${pageContext.request.contextPath}/edituser" method="GET">
        <label class="block clearfix">
            修改信息
        </label>
        <input type="submit" value="前往" style="width:100px;">
    </form>
    <form action="${pageContext.request.contextPath}/addcharacter" method="GET">
        <label class="block clearfix">
            增加角色
        </label>
        <input type="submit" value="前往" style="width:100px;">
    </form>
    <form action="${pageContext.request.contextPath}/showcharlist" method="GET">
        <label class="block clearfix">
            修改角色
        </label>
        <input type="submit" value="前往" style="width:100px;">
    </form>
    <form action="${pageContext.request.contextPath}/showuserlist" method="GET">
        <label class="block clearfix">
            修改用户
        </label>
        <input type="submit" value="前往" style="width:100px;">
    </form>
    <form action="${pageContext.request.contextPath}/blue" method="GET">
        <label class="block clearfix">
            蓝钻专用
        </label>
        <input type="submit" value="前往" style="width:100px;">
    </form>
</form>
<center>
    ${result}
</center>
</body>
</html>
