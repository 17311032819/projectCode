<%@ page import="com.cdvtc.ecommerce.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 吴健军
  Date: 2022/6/7
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <style type="text/css">


        /*页头*/

        /*请登录  注册 .....*/
        #headCon>div{
            width:1200px;
            height: 40px;
            margin:auto;
            margin-top:10px;
        }
        #headCon>div>p{
            float:left;
            font-size:14px;
            color:#999;}
        #headCon>div>ol{
            width:600px;
            float:right;
            overflow:hidden;}
        #headCon>div>ol>li{
            overflow:hidden;
            float:left;
            margin-left: 5px;
        }
        #headCon>div>ol>li>a{
            font-size:14px;
            color:#999;
            float:left;
            margin-right:10px;
        }
        #headCon>div>ol>li>a:hover{
            color:#fb0000;}
        #headCon>div>ol>a{
            width:76px;
            height:14px;
            text-align:center;
            line-height:14px;
            float:left;
            font-size:14px;
            color:#999;
            margin-top:3px;}
        #headCon>div>ol>a:hover{
            color:#fb0000;}
        #headCon>div>ol>.shoppingCar{
            width:150px;
            border:none;
            height:30px;
            float:left;
            overflow:hidden;}
        #headCon>div>ol>.shoppingCar>i{
            float:left;
            width:22px;
            height:18px;
            background:url(images/sprite.png) no-repeat 0px 0px;}
        #headCon>div>ol>.shoppingCar>span{
            float:left;
            margin-left:10px;}

    </style>
</head>
<body>

<%
    User user= (User) session.getAttribute("auth");
    if (user!=null){
        System.out.println(user.getM_mail());
    }
%>
<div id="headCon">
    <div>
        <p>一点超市</p>
        <ol>
            <li><a href="index.jsp">首页</a></li>
            <li>
                <%
                    if (user!=null){%>
                <a href="index.jsp"><%= user.getM_name()%></a>
                <a href="logout.jsp">退出</a>
                <a href="userinfo.jsp">个人信息</a>
                   <% }%>
            <%
                if (user==null){%>
            <a href="login.jsp">请登录</a>
            <% }%>
            </li>
            <li><a href="register.jsp">注册</a></li>
            <a href="order.jsp">我的订单</a>
            <a href="shoppingCar.jsp" class="shoppingCar">
                <i></i>
                <span>购物车（1）</span>
            </a>
        </ol>
    </div>
</div>
</body>
</html>
