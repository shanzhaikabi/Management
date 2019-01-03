<%--
  Created by IntelliJ IDEA.
  User: Shanzhai
  Date: 2019-01-03
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body class="login-layout">

<div class="widget-body" style="width:500px;margin-left: 33%;">
    <div class="widget-main">
        <h4 class="header blue lighter bigger">
            <i class="ace-icon fa fa-coffee green"></i>
            ${result}
        </h4>
        <div class="space-6"></div>
        <%--${pageContext.request.contextPath }--%>
        <form action="${pageContext.request.contextPath}/edituser.do" method="POST">
            <fieldset>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    昵称<input type="text" name="name" class="form-control" value="${user.name}"/>
                                </span><br>
                </label>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    邮箱<input type="text" name="email" class="form-control" value="${user.email}"/>
                                </span><br>
                </label>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    手机号<input type="text" name="tel" class="form-control" value="${user.tel}"/>
                                </span><br>
                </label>
                <div class="space"></div>
                <div class="clearfix" style="text-align: center;">
                    <input type="submit" value="修改" style="width:100px;">
                </div>
                <div class="space-4"></div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
