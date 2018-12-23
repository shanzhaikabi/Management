<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>注册页面</title>

    <meta name="description" content="User login page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/register/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/register/assets/font-awesome/4.2.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/register/assets/fonts/fonts.googleapis.com.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/register/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/register/assets/css/ace-rtl.min.css" />

</head>

<body class="login-layout">

<div class="widget-body" style="width:500px;margin-left: 33%;">
    <div class="widget-main">
        <h4 class="header blue lighter bigger">
            <i class="ace-icon fa fa-coffee red"></i>
            ${failReason}
        </h4>
        <div class="space-6"></div>
        <%--${pageContext.request.contextPath }--%>
        <form action="${pageContext.request.contextPath}/register.do" method="POST">
            <fieldset>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    用户名<input type="text" name="userid" class="form-control" placeholder="用户名" />
                                </span>
                </label>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    昵称<input type="text" name="name" class="form-control" placeholder="昵称" />
                                </span>
                </label>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    密码<input type="password" name="password" class="form-control" placeholder="密码" />
                                </span>
                </label>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    邮箱<input type="text" name="email" class="form-control" placeholder="邮箱" />
                                </span>
                </label>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    手机号<input type="text" name="tel" class="form-control" placeholder="手机号" />
                                </span>
                </label>
                <div class="space"></div>
                <div class="clearfix" style="text-align: center;">
                    <input type="submit" value="提交" style="width:100px;">
                </div>
                <div class="space-4"></div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>