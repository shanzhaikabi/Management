<%--
  Created by IntelliJ IDEA.
  User: Shanzhai
  Date: 2018-12-12
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="GET">
        <label class="block clearfix">
            登陆
        </label>
        <input type="submit" value="前往" style="width:100px;">
    </form>
    <form action="${pageContext.request.contextPath}/mainPage" method="GET">
        <label class="block clearfix">
            主页
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
</body>
</html>
