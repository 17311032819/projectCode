<%@ page import="com.cdvtc.ecommerce.dao.OrderDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cdvtc.ecommerce.model.Order" %>
<%@ page import="com.cdvtc.ecommerce.model.User" %>
<%@ page import="com.cdvtc.ecommerce.model.Product" %>
<%@ page import="com.cdvtc.ecommerce.dao.ProductDao" %><%--
  Created by IntelliJ IDEA.
  User: 吴健军
  Date: 2022/6/7
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!doctype html>
<html>
<head>
    <meta name="keywords" content="甜爱，SweetLove,甜品，甜点，生日蛋糕，冰淇淋，冰品"/>
    <meta name="description" content="甜爱网上商城是专注于甜品销售、进口的网站，各种甜品、甜点齐全，还有解暑的各种冰品任顾客挑选，让他们感受到爱的温馨。">
    <meta charset="utf-8">
    <title>我的甜品，你的爱~</title>
    <link rel="shortcut icon" href="images/logo_01.png">
    <style type="text/css">
        /* CSS Document */
        /*样式重置*/
        *{margin:0px;padding:0px;list-style:none;text-decoration:none;font-family:"微软雅黑", "宋体", "黑体";font-weight:normal;}

        /*内容*/
        #contentCon{
            width:1200px;
            margin:auto;
            margin-top:50px;
            overflow:hidden;}
        #contentCon>.left{
            float:left;
            width:264px;
            height:664px;
            border:1px solid #dcdcdc;
            text-align:center;}
        #contentCon>.left>div{
            width:134px;
            height:134px;
            border-radius:67px;
            background:url(images/order_03.jpg) center no-repeat;
            margin-top:40px;
            margin-left:66px;}
        #contentCon>.left>p{
            font-size:18px;
            color:#4c4c4c;
            margin-top:30px;}
        #contentCon>.left>a{
            display:block;
            width:103px;
            height:34px;
            border:1px solid #d2d2d2;
            background:#eee;
            text-align:center;
            line-height:34px;
            color:#4c4c4c;
            margin-top:20px;
            margin-left:80px;}
        #contentCon>.left>span{
            display:block;
            width:224px;
            height:1px;
            background:#eee;
            margin-left:22px;
            margin-top:22px;}
        #contentCon>.left>ul>li>a{
            font-size:14px;
            display:block;
            margin-top:20px;
            color:#4c4c4c;}
        #contentCon>.left>ul>li>.my{
            color:#fb0000;}
        #contentCon>.right{
            float:left;
            margin-left:10px;
            width:924px;}
        #contentCon>.right>ul{
            width:924px;
            height:50px;
            overflow:hidden;
            background:#eee;}
        #contentCon>.right>ul>li{
            float:left;
            line-height:50px;
            color:#4c4c4c;
            font-size:18px;
            margin-left:105px;}
        #contentCon>.right>ul>.all{
            color:#fb0000;}
        #contentCon>.right>ol{
            width:924px;
            height:56px;
            border-top:1px solid #dcdcdc;
            border-bottom:1px solid #dcdcdc;
            margin-top:30px;
            overflow:hidden;
        }
        #contentCon>.right>ol>input{
            width:18px;
            height:18px;
            margin-top:20px;
            margin-left:30px;
            float:left;
            outline:none;
        }
        #contentCon>.right>ol>p{
            float:left;
            color:#4c4c4c;
            font-size:14px;
            margin-left:14px;
            line-height:58px;}
        #contentCon>.right>ol>a{
            float:right;
            width:25px;
            height:25px;
            background:url(images/sprite.png) no-repeat -687px 0px;
            margin-top:18px;
            margin-right:30px;}
        #contentCon>.right>div{
            overflow:hidden;
            margin-top:30px;
        }
        #contentCon>.right>div>li>img{
            float:left;
            margin-left:30px;
            width:150px;
            height:150px;}
        #contentCon>.right>div>.pic02{
            background:url(images/order_pic_07.jpg) center no-repeat;
        }
        #contentCon>.right>div>.pic03{
            background:url(images/order_pic_11.jpg) center no-repeat;
        }
        #contentCon>.right>div>.pic04{
            background:url(images/order_pic_14.jpg) center no-repeat;
        }
        #contentCon>.right>div>ul{
            float:left;
            overflow:hidden;
            margin-left:20px;}
        #contentCon>.right>div>ul>li{
            float:left;
            margin-top:50px;
            margin-right:70px;
            font-size:14px;
            color:#4c4c4c;}
        #contentCon>.right>div>ul>.price{
            margin-top:70px;}
        #contentCon>.right>div>ul>li>p{
            font-size:14px;
            color:#4c4c4c;}
        #contentCon>.right>div>ul>li>span{
            display:block;
            font-size:14px;
            color:#4c4c4c;
            margin-top:20px;}
        #contentCon>.right>div>ul>li>a{
            display:block;
            font-size:14px;
            color:#4c4c4c;}
        #contentCon>.right>div>ul>li>.text02{
            margin-top:20px;}
        #contentCon>.right>div>ul>a{
            float:left;
            width:75px;
            height:28px;
            background:#eee;
            color:#4c4c4c;
            line-height:28px;
            text-align:center;
            margin-top:70px;}
        #contentCon>.right>div>ol{
            display:block;
            width:924px;
            height:1px;
            background:#dcdcdc;}
        #contentCon>ol{
            width:300px;
            margin-left:940px;
            overflow:hidden;}
        #contentCon>ol>a{
            margin-top:50px;
            float:left;
            width:28px;
            height:28px;
            border: 1px solid #eee;
            font-size:18px;
            color:#4c4c4c;
            line-height:28px;
            margin-right:5px;
            text-align:center;}
        #contentCon>ol>#left{
            margin-right:15px;}
        #contentCon>ol>#right{
            margin-left:10px;}
        #contentCon>ol>#NO1{
            background:#fb0000;
            color:#fff;}


    </style>
</head>

<body>
<%
    User user= (User) session.getAttribute("auth");
    if (user==null){
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }
    String m_no=user.getM_no();
    OrderDao orderDao=new OrderDao();
    List<Order> orderList=orderDao.getOrdersBymno(m_no);

    ProductDao productDao=new ProductDao();
%>
<!--页头-->
<jsp:include page="include/header.jsp"></jsp:include>

<!--内容-->
<div id="contentCon">
    <div class="left">
        <div></div>
        <p>晨曦夏夜</p>
        <a href="#">切换账号</a>
        <span></span>
        <ul>
            <li><a href="userinfo.jsp">个人信息</a></li>
            <li><a href="#" class="my">我的订单</a></li>
            <li><a href="#">我的钱包</a></li>
            <li><a href="#">优惠特权</a></li>
            <li><a href="#">地址管理</a></li>
            <li><a href="#">账号设置</a></li>
            <li><a href="#">我的足迹</a></li>
            <li><a href="#">收藏夹</a></li>
        </ul>
    </div>
    <div class="right">
        <ul>
            <li class="all">全部订单</li>
            <li>待付款</li>
            <li>已发货</li>
            <li>待评价</li>
            <li>售后服务</li>
        </ul>
        <%for(Order order: orderList) {%>
        <ol>
            <input type="checkbox">
            <p>订单时间：<%= order.getDate()%>&nbsp;&nbsp;&nbsp;&nbsp;订单号：<%= order.getO_no()%></p>
            <a href="#"></a>
        </ol>
        <div>
            <li>
                <img src="images/<%=order.getG_no() %>/<%=productDao.getProductByGno(order.getG_no()).getMain_image()%>">

            </li>
            <ul>
                <li>
                    <span><%= order.getG_name()%></span>
                </li>
                <li class="price">总价:<%= order.getPrice()*order.getNumber()%></li>

                <li>
                    <a href="orderDetails.jsp?orderno=<%=order.getO_no()%>" class="text02">订单详情</a>
                </li>
            </ul>
        </div>

        <% }%>


    </div>

</div>
<!--页脚-->
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>

