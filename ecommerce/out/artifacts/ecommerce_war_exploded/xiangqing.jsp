<%@ page import="com.cdvtc.ecommerce.model.Product" %>
<%@ page import="com.cdvtc.ecommerce.dao.ProductDao" %><%--
  Created by IntelliJ IDEA.
  User: 吴健军
  Date: 2022/6/2
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>我的甜品，你的心~</title>
    <link rel="shortcut icon" href="images/logo_01.png">
    <style type="text/css">
        /* CSS Document */
        /*样式重置。 list-style:none 去掉无序列表小圆点。如果浏览器不支持第一个字体，则会尝试下一个。字体加粗。数字值400等于关键字normal，700 等于bold*/
        *{margin:0px;padding:0px;list-style:none;text-decoration:none;font-family:"微软雅黑", "宋体", "黑体";font-weight:normal;}
        /*页头*/
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
        /*内容*/
        #contentCon{
            width:1200px;
            margin:auto;
        }
        /* 标题 */
        #contentCon>ul{
            width:1200px;
            margin:auto;
            margin-top:30px;
            overflow:hidden;
        }
        #contentCon>ul>li{
            float:left;
            font-size:24px;
            color:#4c4c4c;
        }
        #contentCon>ul>.right{
            float:right;
            font-size:18px;
        }
        #contentCon>ul>.right>a{
            display:inline-block;/* 块或行内转行内块 */
            width:65px;
            height:18px;
            border-right:1px solid #d2d2d2;
            color:#4c4c4c;
            text-align:center;
        }
        #contentCon>ul>.right>a:hover{
            color:#fb0000;
        }
        /* 去掉评价后面的竖线 */
        #contentCon>ul>.right>.pingjia{
            border:none;
        }
        #contentCon>#show1{
            overflow:hidden;
            margin-top:80px;
        }
        #contentCon>#show1>div>ul{
            height:500px;
            width: 120px;
        }
        div.left{
            width: 120px;
            height: 500px;
            float: left;
        }

        div.pic05{
            width:500px;
            height:510px;
            margin-left:10px;
            float: left;

        }
        div.pic05 img{
            width:500px;
            height:495px;
        }

        div.right{
            height: 600px;
            width: 500px;
        }
        /* 左侧四张图片 */
        #contentCon>#show1>div>ul>li>img{
            width:120px;
            height:120px;
            padding-top: 1px;

        }
        #contentCon>#show1>div>ul{
            float: left;
            width: 120px;
            height: 500px;
        }
        /* 中间大图 */




        /* 大图右边描述 */
        #contentCon>#show1>.right{
            margin-left:20px;
            float: left;;
        }
        #contentCon>#show1>.right>p{
            font-size:24px;
            color:#4c4c4c;
            margin-left:20px;
        }
        #contentCon>#show1>.right>div{
            width:476px;
            height:160px;
            background:#eee;
            margin-top:20px;
        }

        #contentCon>#show1>.right>div>ul{
            overflow:hidden;
            padding-top:20px;
        }
        /* 金钱符号¥设置 */
        #contentCon>#show1>.right>div>ul>span{
            font-size:24px;
            color:#fb0000;
            float:left;
            margin:5px 10px 0 20px;
        }
        /* 金钱数额设置 */
        #contentCon>#show1>.right>div>ul>h2{
            font-size:30px;
            color:#fb0000;
            float:left;
        }
        /* 降价通知设置 */
        #contentCon>#show1>.right>div>ul>p{
            font-size:14px;
            color:#4c4c4c;
            margin-left:18px;
            margin-top:14px;
        }

        #contentCon>#show1>.right>div>ol{
            margin-top:20px;
            margin-left:20px;
        }
        /* 特惠设置 */
        #contentCon>#show1>.right>div>ol>.tehui{
            display:inline-block;/* 块或行内转行内块 */
            width:54px;
            height:26px;
            background:#fb0000;
            color:#fff;
            line-height:26px;
            text-align:center;
            font-size:18px;
            border-radius:4px;
            margin:0;
        }
        /* 特惠描述文字设置 */
        #contentCon>#show1>.right>div>ol>a{
            font-size:16px;
            color:#fb0000;
            margin-left:22px;
        }

        /* 服务部分设置 */
        #contentCon>#show1>.right>div>li{
            overflow:hidden;
            margin-top:20px;
            margin-left:20px;
        }
        /* 服务 */
        #contentCon>#show1>.right>div>li>p{
            float:left;
            font-size:16px;
            color:#4c4c4c;
            margin-right:24px;
        }
        #contentCon>#show1>.right>div>li>div{
            overflow:hidden;
            margin-left:22px;
        }
        /* . */
        #contentCon>#show1>.right>div>li>div>span{
            font-size:24px;
            color:#4c4c4c;
            float:left;
            margin-top:-13px;
            margin-right:5px;
            margin-left:8px;
        }
        /* 文字 */
        #contentCon>#show1>.right>div>li>div>p{
            float:left;
            font-size:14px;
            color:#4c4c4c;
        }

        /* 规格部分 */
        #contentCon>#show1>.right>ul{
            margin-top:28px;
            margin-left:18px;
        }
        #contentCon>#show1>.right>ul>li{
            background:none;
            width:360px;
            height:50px;
            margin-left:28px;
        }
        #contentCon>#show1>.right>ul>.check01{
            margin:0;
        }
        /* 规格文字设置 */
        #contentCon>#show1>.right>ul>li>p{
            float:left;
            font-size:14px;
            color:#4c4c4c;
            margin-top:8px;
        }
        #contentCon>#show1>.right>ul>li>span{
            display: inline-block;
            width:82px;
            height:32px;
            border:1px solid #d2d2d2;
            line-height:32px;
            text-align:center;
            color:#4c4c4c;
            font-size:14px;
            margin-left:20px;
        }

        /* 数量部分 */
        #contentCon>#show1>.right>ul>ol{
            margin-top:20px;
            width:160px;
            overflow:hidden;
        }
        #contentCon>#show1>.right>ul>ol>p{
            float:left;
            font-size:14px;
            color:#4c4c4c;
            margin-top:5px;
            margin-right:20px;
        }
        #contentCon>#show>.right>ul>ol>button{
            color:#999;
            font-size: 25px;
            line-height: 1px;
            width: 20px;
            height: 30px;
        }
        #contentCon>#show1>.right>ul>ol>input{
            width:30px;
            height:30px;
            border:1px solid #d2d2d2;
            color:#4c4c4c;
            padding-left:24px;
            margin-left: 1px;
            margin-right: 1px;
        }
        /* 立刻购买/加入购物车部分 */
        #contentCon>#show1>.right>ul>a{
            float:left;
            margin-top:30px;
        }
        div.buyandcar{
            width: 500px;
            height: 200px;
        }

        div.buyandcar a.buy{
            clear: both;
            width:132px;
            height:40px;
            background:#fb0000;
            color:#fff;
            line-height:40px;
            text-align:center;
            font-size:18px;
            border-radius:8px;
            float: left;
        }

        div.buyandcar a.car{
            float: left;
            width:132px;
            height:40px;
            border:1px solid #fb0000;
            color:#fb0000;
            line-height:40px;
            text-align:center;
            font-size:18px;
            border-radius:8px;
            margin-left: 20px;
        }

        div.buyandcar a.love{
            margin-left: 20px;
            float: left;
            width:38px;
            height:38px;
            background:url(images/hert.png) center no-repeat;
        }


        #contentCon>#show1>.right>ul>.buy{
            clear: both;
            width:132px;
            height:40px;
            background:#fb0000;
            color:#fff;
            line-height:40px;
            text-align:center;
            font-size:18px;
            border-radius:8px;
        }
        #contentCon>#show1>.right>ul>.car{
            width:132px;
            height:40px;
            border:1px solid #fb0000;
            color:#fb0000;
            line-height:40px;
            text-align:center;
            font-size:18px;
            border-radius:8px;
            float: left;
        }

        #contentCon>#show1>.right>ul>.love{
            float: left;
            width:38px;
            height:38px;
            background:url(images/hert.png) center no-repeat;
        }

        #contentCon>#details{
            margin-top:90px;
        }
        #contentCon>#details>ul>div{
            float:left;
        }

        /* Details */
        #contentCon>#details>ul>div>p{
            font-size:20px;
            color:#4c4c4c;
        }
        #contentCon>#details>ul>div>span{
            display:block;/* 属性规定元素应该生成的框的类型 */
            width:60px;
            height:3px;
            background:#fb0000;
        }
        /* 商品详情 */
        #contentCon>#details>ul>p{
            font-size:24px;
            color:#fb0000;
            margin-left:10px;
            float:left;
        }
        #contentCon>#details>ul>span{
            float:left;
            width:1020px;
            height:1px;
            background:#d2d2d2;
            margin-top:25px;
            margin-left:8px;
        }
        /* 品名/品牌部分 */
        #contentCon>#details>ol>li{
            overflow:hidden;
            width:1200px;
            height:76px;
            border-bottom:1px dotted #d7d7d7;
        }
        #contentCon>#details>ol>li>div{
            margin-left:235px;
            float:left;
            overflow:hidden;
        }
        #contentCon>#details>ol>li>.text02{
            margin-left:364px;
        }
        #contentCon>#details>ol>li>.text03{
            margin-left:200px;
        }
        #contentCon>#details>ol>li>.text04{
            margin-left:272px;
        }
        #contentCon>#details>ol>li>div>p{
            float:left;
            font-size:18px;
            color:#4c4c4c;
            line-height:80px;
            margin-right:40px;
        }
        #contentCon>#details>ol>li>div>span{
            float:left;
            font-size:18px;
            color:#4c4c4c;
            line-height:80px;
        }
        /* 配料部分 */
        #contentCon>#details>ol>div{
            margin-top:24px;
            margin-left:236px;
        }
        #contentCon>#details>ol>div>span{
            font-size:18px;
            color:#4c4c4c;
        }
        #contentCon>#details>ol>div>p{
            font-size:18px;
            color:#4c4c4c;
            margin-top:15px;
            line-height:27px;
        }

        /* 起源部分 */
        #contentCon>#origin{
            margin-top:90px;
        }
        #contentCon>#origin>ul{
            overflow:hidden;
        }
        #contentCon>#origin>ul>div{
            float:left;
        }
        #contentCon>#origin>ul>div>p{
            font-size:20px;
            color:#4c4c4c;
        }
        #contentCon>#origin>ul>div>span{
            display:block;
            width:60px;
            height:3px;
            background:#fb0000;
        }
        /* 商品起源文字设置 */
        #contentCon>#origin>ul>p{
            font-size:24px;
            color:#fb0000;
            margin-left:10px;
            float:left;
        }
        #contentCon>#origin>ul>span{
            float:left;
            width:1020px;
            height:1px;
            background:#d2d2d2;
            margin-top:25px;
            margin-left:8px;
        }
        #contentCon>#origin>ol{
            overflow:hidden;
            margin-top:80px;
            margin-left:50px;
        }
        #contentCon>#origin>ol>li{
            float:left;
            width:550px;
            height:600px;
        }
        #contentCon>#origin>ol>li>img{
            float:left;
            width:550px;
            height:600px;
        }
        #contentCon>#origin>ol>div{
            float:left;
            width:508px;
            height:288px;
            background:url(images/origin02_03.jpg) center no-repeat;
            margin-top:140px;
            margin-left:40px;
        }
        #contentCon>#origin>ol>div>p{
            font-size:16px;
            color:#4c4c4c;
            line-height:24px;
            margin-top:64px;
            margin-left:30px;
        }

        /* 成分部分 */
        #contentCon>#Indredient{
            margin-top:90px;
        }
        #contentCon>#Indredient>ul{
            overflow:hidden;
        }
        #contentCon>#Indredient>ul>div{
            float:left;
        }
        /* Indredient */
        #contentCon>#Indredient>ul>div>p{
            font-size:20px;
            color:#4c4c4c;
        }
        #contentCon>#Indredient>ul>div>span{
            display:block;
            width:100px;
            height:3px;
            background:#fb0000;
        }
        /* 商品成分 */
        #contentCon>#Indredient>ul>p{
            font-size:24px;
            color:#fb0000;
            margin-left:10px;
            float:left;
        }
        #contentCon>#Indredient>ul>span{
            float:left;
            width:980px;
            height:1px;
            background:#d2d2d2;
            margin-top:25px;
            margin-left:8px;
        }
        #contentCon>#Indredient>ol{
            margin:auto;
            margin-top:50px;
            width:815px;
            height:490px;
        }
        #contentCon>#Indredient>ol>img{
            width:750px;
            height:600px;
        }
        #contentCon>#show{
            margin-top:90px;
        }
        #contentCon>#show>ul{
            overflow:hidden;
        }
        #contentCon>#show>ul>div{
            float:left;
        }
        /* Show */
        #contentCon>#show>ul>div>p{
            font-size:20px;
            color:#4c4c4c;
        }
        #contentCon>#show>ul>div>span{
            display:block;
            width:50px;
            height:3px;
            background:#fb0000;
        }
        /* 商品展示 */
        #contentCon>#show>ul>p{
            font-size:24px;
            color:#fb0000;
            margin-left:10px;
            float:left;
        }
        #contentCon>#show>ul>span{
            float:left;
            width:1030px;
            height:1px;
            background:#d2d2d2;
            margin-top:25px;
            margin-left:8px;
        }
        #contentCon>#show>ol{
            margin-top:50px;
        }
        /* 商品展示的三张图 */
        #contentCon>#show>ol>li>img{
            width:1200px;
            height:700px;
        }
        #contentCon>#show>ol>div{
            margin-top:20px;
        }
        #contentCon>#show>ol>div>li>img{
            float:left;
            width:474px;
            height:650px;
        }
        #contentCon>#show>ol>div>span>img{
            float:left;
            width:708px;
            height:650px;
            margin-left:18px;
        }

        /*页脚*/
        /* 3大优势描述位置和背景设置 */
        #footCon>ul{
            width:1200px;
            height:168px;
            background:#eee;
            margin:auto;
            overflow:hidden;
            margin-top:80px;
        }
        #footCon>ul>li{
            width:330px;
            float:left;
            margin-top:45px;
            margin-left:70px;
            overflow:hidden;
        }
        #footCon>ul>li>.cold{
            width:65px;
            height:65px;
            background:url(images/sprite.png) no-repeat -351px 0px;
            float:left;
            margin-top:10px;
        }
        #footCon>ul>li>.wuxiu{
            width:69px;
            height:69px;
            background:url(images/sprite.png) no-repeat -418px 0px;
            float:left;
            margin-top:10px;
        }
        #footCon>ul>li>.baoyou{
            width:58px;
            height:72px;
            background:url(images/sprite.png) no-repeat -488px 0px;
            float:left;
            margin-top:10px;
        }
        /* 文字描述左边一竖线 */
        #footCon>ul>li>span{
            float:left;
            width:1px;
            height:80px;
            background:#fb0000;
            margin:0 30px 0 30px;
        }
        #footCon>ul>li>ol>h2{
            font-size:30px;
            color:#fb0000;

        }
        #footCon>ul>li>ol>p{
            font-size:24px;
            color:#4c4c4c;
            margin-top:10px;
        }
        #footCon>ol{
            width:1200px;
            margin:auto;
            margin-top:50px;
            overflow:hidden;
        }
        /* 页脚网址设置 */
        #footCon>ol>li{
            float:left;
            margin-left:120px;
            margin-right:85px;
        }
        /* 网址左图 */
        #footCon>ol>li>i{/* block：此元素将显示为块级元素，此元素前后会带有换行符。 */
            display:block; /* block块页面布局中,主要是用来将内容从上到下排列的 */
            width:92px;
            height:62px;
            background:url(images/sprite.png) no-repeat -23px 0px;
            margin-left:20px;
        }
        /* 设置微博/微信图标 */
        #footCon>ol>li>a{
            display:block;
            font-size:14px;
            color:#4c4c4c;
            margin-top:20px;
        }
        #footCon>ol>li>div{
            overflow:hidden;
            margin-top:24px;
            margin-left:10px;
        }
        #footCon>ol>li>div>.weibo{
            float:left;
            width:33px;
            height:27px;
            background:url(images/sprite.png) no-repeat -546px 0px;
        }
        #footCon>ol>li>div>.weixin{
            float:left;
            width:36px;
            height:30px;
            background:url(images/sprite.png) no-repeat -582px 0px;
            margin-left:40px;
        }
        /* 页脚文字 */
        #footCon>ol>ul{
            float:left;
            width:540px;
            border-left:1px solid #b5b5b5;
            border-right:1px solid #b5b5b5;

        }
        #footCon>ol>ul>li{
            float:left;
            margin-right:50px;
        }
        #footCon>ol>ul>.text01{
            margin-left:80px;
        }
        #footCon>ol>ul>li>p{
            font-size:14px;
            color:#4c4c4c;
        }
        /* 下划灰线 */
        #footCon>ol>ul>li>span{
            display:block;
            width:50px;
            height:1px;
            background:#b5b5b5;
            margin-left:5px;
            margin-top:10px;
        }
        #footCon>ol>ul>li>a{
            display:block;
            font-size:14px;
            color:#808080;
            margin-top:20px;
        }
        /* “联系我们”描述div */
        #footCon>ol>div{
            text-align:center;
            float:left;
            margin-left:50px;
        }
        #footCon>ol>div>p{
            font-size:14px;
            color:#4d4d4d;
        }
        #footCon>ol>div>h2{
            font-size:18px;
            color:#4c4c4c;
            margin-top:20px;
        }
        #footCon>ol>div>span{
            display:block;/* block：此元素将显示为块级元素，此元素前后会带有换行符。将内容从上到下排列. */
            font-size:14px;
            color:#4d4d4d;
            margin-top:20px;
        }
        /* 在线客服的圆弧背景 */
        #footCon>ol>div>a{
            display:block;
            border-radius:8px;
            width:75px;
            height:25px;
            background:#b5b5b5;
            color:#fff;
            margin-top:20px;
            margin-left:26px;
            font-size:14px;
            line-height: 25px;
        }
        /* 页脚分割 */
        #footCon>div{
            margin:auto;
            width:1200px;
            height:1px;
            background:#b5b5b5;
            margin-top:30px;
        }
        /* 版权 */
        #footCon>li{
            width:1200px;
            margin:auto;
            text-align:center;
            font-size:14px;
            margin-top:40px;
            color:#808080;
        }
        #footCon>li>span{
            display:block;
            margin-top:20px;
        }
    </style>
</head>

<body>
<%
    String g_no=request.getParameter("g_no");
    Product product=new Product();
    ProductDao productDao=new ProductDao();
    product=productDao.getProductByGno(g_no);
    System.out.println(product.getDetails05());
%>
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
<!--内容-->
<div id="contentCon">
    <ul>
        <li><h2><%=product.getG_name()%></h2></li>
        <li class="right">
            <a href="#">概述</a>
            <a href="#">图集</a>
            <a href="#">参数</a>
            <a href="#" class="pingjia">评价</a>
        </li>
    </ul>
    <div id="show1">
        <div class="left">
            <ul class="pic01234">
                <li>
                    <img src="images/<%=product.getG_no()%>/<%=product.getDetails01()%>">
                </li>
                <li class="pic02">
                    <img src="images/<%=product.getG_no()%>/<%=product.getDetails02()%>">
                </li>
                <li class="pic03">
                    <img src="images/<%=product.getG_no()%>/<%=product.getDetails03()%>">
                </li>
                <li class="pic04">
                    <img src="images/<%=product.getG_no()%>/<%=product.getDetails04()%>">
                </li>
            </ul>



        </div>
        <div class="pic05">
            <img src="images/<%=product.getG_no()%>/<%=product.getDetails05()%>">
        </div>
        <div class="right">
            <p>【自营】 <%= product.getG_name()%></p>
            <div>
                <ul>
                    <span>¥</span>
                    <h2><%=product.getG_price()%></h2>
                    <p>（降价通知）</p>
                </ul>
                <ol>
                    <a href="#" class="tehui">特惠</a>
                    <a href="#">领取满150减15元券，先到先得</a>
                </ol>
                <li>
                    <p>服务</p>
                    <div>
                        <span>.</span>
                        <p>满88元包邮</p>
                        <span>.</span>
                        <p>不支持无理由货</p>
                        <span>.</span>
                        <p>48小时极速退款</p>
                    </div>
                </li>
            </div>
            <ul>
                <li class="check01">
                    <p>规格</p>
                    <span><%=product.getG_quantity()%></span>
                    <span><%=product.getG_quantity()%></span>
                    <span><%=product.getG_quantity()%></span>
                </li>
                <li>
                    <span><%=product.getG_quantity()%></span>
                    <span><%=product.getG_quantity()%></span>
                </li>
                <ol>
                    <p>数量</p>
                    <button type="button">-</button><input value="1"><button type="button">+</button>
                    <!-- <a href="">-</a><input value="1"><a href="">+</a> -->
                </ol>

                <div class="buyandcar">
                    <a href="pay.jsp" class="buy">立刻购买</a>
                    <a href="shoppingCar.jsp" class="car">加入购物车</a>
                    <a href="#" class="love"></a>
                </div>


            </ul>
        </div>
    </div>
    <div id="details">
        <ul>
            <div>
                <p>Details</p>
                <span></span>
            </div>
            <p>商品详情</p>
            <span></span>
        </ul>
        <ol>
            <li>
                <div>
                    <p>品名</p>
                    <span><%= product.getG_name()%></span>
                </div>
                <div class="text02">
                    <p>品牌</p>
                    <span>【自营】</span>
                </div>
            </li>
            <li>
                <div>
                    <p>规格</p>
                    <span><%= product.getG_quantity()%></span>
                </div>
                <div class="text03">
                    <p>保质期</p>
                    <span>3天</span>
                </div>
            </li>
            <li>
                <div>
                    <p>同城服务</p>
                    <span>同城24小时送达</span>
                </div>
                <div class="text04">
                    <p>贮存条件</p>
                    <span>阴凉干燥处</span>
                </div>
            </li>
            <div>
                <span>配料</span>
                <p>小麦粉，白砂糖，起酥油，人造奶油，鸡蛋，核桃仁，卡士达粉（白砂糖
                    ，起酥油，奶粉，<br>乙酰化二淀粉磷酸酯，食用香精，β-胡萝卜素），红茶，食用盐，食品添加剂（复配膨<br>
                    松剂（碳酸氢钠，焦磷酸二氢二钠，磷酸氢钙，玉米淀粉）碳酸氢钠，碳酸氢铵），液体<br>
                    调味料（水，糯米，大米，柠檬汁）</p>
            </div>
        </ol>
    </div>
    <div id="origin">
        <ul>
            <div>
                <p>Origin</p>
                <span></span>
            </div>
            <p>商品起源</p>
            <span>
            </span>
        </ul>
        <ol>
            <li>                                <img src="images/<%=product.getG_no()%>/<%=product.getOrigin()%>">
            </li>
            <div>
                <p>一个意大利士兵即将开赴战场，可是家里已经什么也没有了，爱<br>
                    他的妻子为了给他准备干粮，把家里所有能吃的饼干、面包全做<br>
                    进了一个糕点里，意为带我走，那个糕点就叫提拉米苏。每当这<br>
                    个士兵在战场上吃到提拉米苏就会想起他的家，想起家中的爱人<br>
                    。在意大利文里，提拉米苏有 “ 带我走 ” 的含义，带走的不只<br>是美味，还有爱和幸福</p>
            </div>
        </ol>
    </div>
    <div id="Indredient">
        <ul>
            <div>
                <p>Indredient</p>
                <span></span>
            </div>
            <p>商品成分</p>
            <span>
            </span>
        </ul>
        <ol>
            <img src="images/<%=product.getG_no()%>/<%=product.getIndredient()%>">
        </ol>
    </div>
    <div id="show">
        <ul>
            <div>
                <p>Show</p>
                <span></span>
            </div>
            <p>商品展示</p>
            <span></span>
        </ul>
        <ol>
            <li>
                <img src="images/<%=product.getG_no()%>/<%=product.getShow01()%>">
            </li>
            <div>
                <li>
                    <img src="images/<%=product.getG_no()%>/<%=product.getShow02()%>">
                </li>
                <span>
                <img src="images/<%=product.getG_no()%>/<%=product.getShow03()%>">
                </span>
            </div>
        </ol>
    </div>
</div>
<!--页脚-->
<div id="footCon">
    <ul>
        <li>
            <div class="cold"></div>
            <span></span>
            <ol>
                <h2>18小时低温</h2>
                <p>全程冷链配送</p>
            </ol>
        </li>
        <li>
            <div class="wuxiu"></div>
            <span></span>
            <ol>
                <h2>7*24小时营业</h2>
                <p>全年无休</p>
            </ol>
        </li>
        <li>
            <div class="baoyou"></div>
            <span></span>
            <ol>
                <h2>满88包邮</h2>
                <p>次日送达</p>
            </ol>
        </li>
    </ul>
    <ol>
        <li>
            <i></i>
            <a href="index.jsp">www.sweetlove.com</a>
            <div>
                <a href="http://www.weibo.com" class="weibo"></a>
                <a href="http://wx.qq.com" class="weixin"></a>
            </div>
        </li>
        <ul>
            <li class="text01">
                <p>关于甜爱</p>
                <span></span>
                <a href="#">媒体报道</a>
                <a href="#">知识产权</a>
                <a href="#">加入我们</a>
            </li>
            <li>
                <p>帮助中心</p>
                <span></span>
                <a href="#">购物指南</a>
                <a href="#">订单管理</a>
                <a href="#">常见问题</a>
            </li>
            <li>
                <p>服务支持</p>
                <span></span>
                <a href="#">服务保障</a>
                <a href="#">用户协议</a>
                <a href="#">售后服务</a>
            </li>
            <li>
                <p>商业合作</p>
                <span></span>
                <a href="#">集合采购</a>
                <a href="#">品牌合作</a>
                <a href="#">媒体合作</a>
            </li>
        </ul>
        <div>
            <p>联系我们</p>
            <h2>400-8888-000</h2>
            <span>24小时服务热线</span>
            <a href="#">在线客服</a>
        </div>
    </ol>
    <div></div>
    <li>
        <p>Copyright © 2021 sweetlove.com Inc.All Rights Reserved. 成都甜心食品有限公司</p>
        <span>版权所有 蜀ICP备14049996号-1 增值电信业务经营许可证：川ICP证160061号</span>
    </li>
</div>
</body>
</html>

