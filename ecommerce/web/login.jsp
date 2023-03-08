<%@page import="java.util.*"%>
<%@ page import="com.cdvtc.ecommerce.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
  User auth = (User) request.getSession().getAttribute("auth");
  if (auth != null) {
    response.sendRedirect("index.jsp");
  }
%>
<!DOCTYPE html>
<html>
<head>
<%--  <%@include file="/includes/head.jsp"%>--%>
  <title>一点超市</title>
  <style type="text/css">
    #headCon{
      min-width:1200px;/* 设置段落的最小宽度 */
    }
    #headCon>div{
      width:1200px;
      margin:auto;
      margin-top:10px;
    }
    #headCon>div>p{
      float:left;
      font-size:14px;
      color:#999;
    }
    #headCon>div>ol{
      width:300px;
      float:right;
    }
    #headCon>div>ol>li{
      float:left;
    }
    #headCon>div>ol>li>a{
      font-size:14px;
      color:#999;
      float:left;
      margin-right:10px;
    }
    #headCon>div>ol>li>a:hover{
      color:#fb0000;
    }
    #headCon>div>ol>a{
      width:76px;
      height:14px;
      text-align:center;
      line-height:14px;
      float:left;
      font-size:14px;
      color:#999;
      border-left:1px solid #a1a1a1;
      border-right:1px solid #a1a1a1;
      margin-top:3px;
    }
    #headCon>div>ol>a:hover{
      color:#fb0000;
    }
    #headCon>div>ol>.shoppingCar{
      margin-left:10px;
      width:120px;
      border:none;
      height:20px;
      float:left;
    }
    /* 购物车图标 */
    #headCon>div>ol>.shoppingCar>i{
      float:left;
      width:22px;
      height:18px;
      vertical-align:middle;
      background:url(images/sprite.png) no-repeat 0px 0px;
    }
    #headCon>ul{
      width:1200px;
      margin:auto;
      overflow:hidden;
      padding-top:30px;
    }
    #headCon>ul>a>li{
      width:92px;
      height:63px;
      background:url(images/sprite.png) no-repeat -22px 0px;
    }
    #headCon>ul>a{
      float:left;
    }
    #headCon>ul>ol{
      float:left;
      margin-left:180px;
    }
    #headCon>ul>ol>li{
      float:left;
      margin-top:25px;
      margin-right:40px;
    }
    #headCon>ul>ol>li>a{
      font-size:18px;
      color:#4c4c4c;
    }
    #headCon>ul>ol>li>a:hover{
      color:#fb0000;
    }



    #headCon>ul>ol>.search{
      margin-top:10px;
      margin-left:90px;
    }
    #headCon>ul>ol>.search>input{
      width:254px;
      height:40px;
      border:1px solid #fb0000;
      border-radius:20px;
      color:#999;
      padding-left:16px;
      font-size:16px;
    }
    #headCon>ul>ol>.search>button{
      width:29px;
      height:29px;
      background:url(images/sprite.png) no-repeat -115px 0px;
      border:none;/* 去掉放大镜图片边框 */
      vertical-align:middle;/* 垂直居中 */
      margin-left:-60px;
    }
    #headCon>ol{
      width:1200px;
      height:1px;
      margin:auto;
      background:#d2d2d2;
      margin-top:30px;
    }

  </style>

  <link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
<%--<%@include file="/includes/navbar.jsp"%>--%>
<!--页头-->
<div id="headCon">
  <div>
    <p>我的甜品 你的心~</p>
    <ol>
      <li><a href="login.jsp">请登录</a></li>
      <li><a href="register.jsp">注册</a></li>
      <a href="order.jsp">我的订单</a>
      <a href="shoppingCar.jsp" class="shoppingCar">
        <i></i>
        <span>购物车&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
      </a>
    </ol>
  </div>
  <ul>
    <a href="index.jsp"><li></li></a>
    <ol>
      <li><a href="index.jsp">首页</a></li>
      <li><a href="western.jsp">西式甜品</a></li>
      <li><a href="Hong Kong.jsp">港式甜品</a></li>

      <li class="search">
        <input value="提拉米苏"><button></button>
      </li>
    </ol>
  </ul>
  <ol></ol>
</div>
<div class="container">
  <div class="card w-50 mx-auto my-5">
    <div class="card-header text-center">会员登陆</div>
    <div class="card-body">
      <form action="user-login" method="post">
        <div class="form-group">
          <label>电子邮件</label>
          <input type="email" name="login-email" class="form-control" placeholder="请输入电子邮件">
        </div>
        <div class="form-group">
          <label>密码</label>
          <input type="password" name="login-password" class="form-control" placeholder="请输入密码">
        </div>
        <div class="text-center">
          <button type="submit" class="btn btn-primary">登陆</button>
        </div>
      </form>
    </div>
  </div>
</div>

<%--<%@include file="/includes/footer.jsp"%>--%>
</body>
</html>
