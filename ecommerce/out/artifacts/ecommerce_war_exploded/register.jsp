<%--
  Created by IntelliJ IDEA.
  User: 吴健军
  Date: 2022/6/2
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>欢迎注册！</title>
    <script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="https://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <link rel="shortcut icon" href="images/logo_01.png">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/bootstrap-datepicker3.min.css">
    <link rel="stylesheet" href="./css/main.css">
    <style type="text/css">
        form{
            margin-left: 400px;
            width: 500px;
        }
    </style>
</head>

<body>
<!--页头-->
<jsp:include page="include/header.jsp"></jsp:include>
<!--内容-->
<form action="RegisterServlet" method="post" id="signupForm">
    <div class="form-group">
        <label>昵称<span class="text-danger">*</span></label>
        <input type="text" class="form-control" name="nickname" placeholder="请输入名称" value="${param.nickname}">
    </div>
    <div class="form-group">
        <label>密码<span class="text-danger">*</span></label>
        <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码">
    </div>
    <div class="form-group">
        <label>确认密码</label>
        <input type="password" class="form-control" name="confirmPwd" placeholder="请再次输入密码">
        <p class="text-danger">${error_password}</p>

    </div>
    <div class="form-group">
        <label>手机<span class="text-danger">*</span></label>
        <input type="number" class="form-control" name="mobile" placeholder="请输入手机号码" value="${param.mobile}">
    </div>
    <div class="form-group">
        <label>电子邮件</label>
        <input type="email" class="form-control" name="email" placeholder="请输入电子邮件" value="${param.email}">
        <p class="text-danger">${error_email}</p>
    </div>
    <div class="form-group">
        <label>出生日期</label>
        <input type="text" class="form-control" name="birthday" id="datetimepicker" placeholder="请选择您的出生日期" value="${param.birthday}">
    </div>
    <div class="form-group">
        <button class="btn btn-primary btn-block" type="submit">注册</button>
    </div>
    <div class="form-group">
        <label>性别</label>
        <div>
            <label class="radio-inline">
                <input type="radio" name="sex" value="男" checked><label>男</label>
            </label>
            &nbsp;
            &nbsp;
            &nbsp;
            &nbsp;
            <label class="radio-inline">
                <input type="radio" name="sex" value="女"><label>女</label>
            </label>
        </div>
    </div>

</form>
<!--页脚-->
<jsp:include page="include/footer.jsp"></jsp:include>

</body>
</html>
