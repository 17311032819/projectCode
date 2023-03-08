<%@ page import="com.cdvtc.ecommerce.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 吴健军
  Date: 2022/6/7
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><!doctype html>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<%
    User user= (User) session.getAttribute("auth");
    if (user==null){
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

%>
<jsp:include page="include/header.jsp"></jsp:include>
<div class="container">
    <div class="container">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">
                    修改个人信息
                </h3>
            </div>
            <div class="panel-body" style="padding: 20px;">
                <form action="UserInfoServlet" class="form-horizontal" role="form" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="account" class="col-sm-2 control-label">ID：</label>
                        <div class="col-sm-10">
                            <input type="text" readonly class="form-control" name="account" id="account" placeholder="<%=user.getM_no()%>" value="${sessionScope.user.account}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nickname" class="col-sm-2 control-label">昵称：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="nickname" id="nickname" placeholder="<%=user.getM_name()%>" value="${sessionScope.user.nickname}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="birthday" class="col-sm-2 control-label">生日：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="birthday" id="birthday" placeholder="<%=user.getM_birth()%>" value="${sessionScope.user.birthday}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">电子邮件：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="email" id="email" placeholder="<%=user.getM_mail()%>" value="${sessionScope.user.email}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobile" class="col-sm-2 control-label">手机号码：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="mobile" id="mobile" placeholder="<%=user.getM_phone()%>" value="${sessionScope.user.mobile}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobile" class="col-sm-2 control-label">性别：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="sex" id="sex" placeholder="<%=user.getM_sex()%>" value="${sessionScope.user.mobile}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">确定</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="include/footer.jsp" %>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>
<script src="js/bootstrap-datepicker.zh-CN.min.js"></script>
<script>
    $().ready(function () {
        // 设置日期选择器
        $('#birthday').datepicker({
            language: 'zh-CN', //语言
            clearBtn: true,//清除按钮
            format: "yyyy-mm-dd"//日期格式
        });
    });
</script>
</body>
</html>

