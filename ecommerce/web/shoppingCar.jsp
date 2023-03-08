<%@ page import="com.cdvtc.ecommerce.model.User" %>
<%@ page import="com.cdvtc.ecommerce.model.shoppingCar" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cdvtc.ecommerce.dao.ShoppingCarDao" %><%--
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
    <meta name="keywords" content="甜爱，SweetLove,甜品，甜点，生日蛋糕，冰淇淋，冰品"/>
    <meta name="description" content="甜爱网上商城是专注于甜品销售、进口的网站，各种甜品、甜点齐全，还有解暑的各种冰品任顾客挑选，让他们感受到爱的温馨。">
    <meta charset="utf-8">
    <title>我的甜品，你的爱~</title>
    <link rel="shortcut icon" href="images/logo_01.png">
    <link rel="stylesheet" href="css/shoppingCar.css">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/carts.css">

</head>

<body>

<%
    User user= (User) session.getAttribute("auth");
    if (user==null){
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }
    String m_no=user.getM_no();
    ShoppingCarDao shoppingCarDao=new ShoppingCarDao();
    List<shoppingCar> shoppingCarList=shoppingCarDao.getshoppingcarbymno(m_no);
%>
<!--页头-->
<jsp:include page="include/header.jsp"></jsp:include>
<div id="headCon">
    <ul>
        <a href="index.jsp"><li></li></a>
        <p>我的购物车</p>
        <ol>
            <li>
                <div class="my"><img src="images/shopCar_08.png"></div>
                <p class="red">我的购物车</p>
            </li>
            <li>
                <div class="order"><img src="images/shopCar_03.png"></div>
                <p>确认订单</p>
            </li>
            <li class="pay">
                <div class="pay"><img src="images/shopCar_11.png"></div>
                <p>支付</p>
            </li>
            <li class="bingo">
                <div class="bingo"><img src="images/shopCar_05.png"></div>
                <p>完成</p>
            </li>
        </ol>
    </ul>
</div>
<!--内容-->
<div id="contentCon">
    <ul>
        <li>
            <p>我的商品（<%=shoppingCarList.size()%>）</p>
            <span></span>
        </li>
    </ul>
    <section class="cartMain">
        <div class="cartMain_hd">
            <ul class="order_lists cartTop">
                <li class="list_chk">
                    <!--所有商品全选-->
                    <input type="checkbox" id="all" class="whole_check">
                    <label for="all"></label>
                    全选
                </li>
                <li class="list_con">商品信息</li>
                <li class="list_info">商品参数</li>
                <li class="list_price">单价（元）</li>
                <li class="list_amount">数量</li>
                <li class="list_sum">小计（元）</li>
                <li class="list_op">操作</li>
            </ul>
        </div>

        <div class="cartBox">
            <div class="shop_info">
                <!--<div class="all_check">-->
                    <!--店铺全选-->
                <!--<input type="checkbox" id="shop_a" class="shopChoice">
                <label for="shop_a" class="shop"></label>
            </div>-->
                <!--<div class="shop_name">
                    店铺：<a href="javascript:;">搜猎人艺术生活</a>
                </div>-->
            </div>
            <div class="order_content">
                <%for(shoppingCar shoppingCar: shoppingCarList) {%>
                <ul class="order_lists">
                    <li class="list_chk">
                        <input type="checkbox" id="checkbox_2" class="son_check">
                        <label for="checkbox_2"></label>
                    </li>
                    <li class="list_con">
                        <div class="list_img"><a href="javascript:;"><img src="images/<%=shoppingCar.getG_no()%>/<%=shoppingCar.getMain_img()%>"alt=""></a></div>
                        <div class="list_text"><a href="xiangqing.jsp?<%=shoppingCar.getG_no()%>"><%=shoppingCar.getG_name()%></a></div>
                    </li>
                    <li class="list_info">
                        <p>规&nbsp;&nbsp;&nbsp;&nbsp;格：<%=shoppingCar.getG_quantity()%></p>
                        <p>规&nbsp;&nbsp;&nbsp;&nbsp;格：<%=shoppingCar.getG_quantity()%></p>
                    </li>
                    <li class="list_price">
                        <p class="price"><%=shoppingCar.getG_price()%></p>
                    </li>
                    <li class="list_amount">
                        <div class="amount_box">
                            <a href="javascript:;" class="reduce reSty">-</a>
                            <input type="text" value="1" class="sum">
                            <a href="javascript:;" class="plus">+</a>
                        </div>
                    </li>
                    <li class="list_sum">
                        <p class="sum_price"><%=shoppingCar.getG_price()%></p>
                    </li>
                    <li class="list_op">
                        <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                    </li>
                </ul>
                <%}%>


            </div>
        </div>
        <!--底部-->
        <div class="bar-wrapper">
            <div class="bar-right">
                <div class="piece">已选商品<strong class="piece_num">0</strong>件</div>
                <div class="totalMoney">共计: <strong class="total_text">0.00</strong></div>
                <div class="calBtn"><a href="pay.jsp" href="javascript:;">结算</a></div>
            </div>
        </div>
    </section>
    <section class="model_bg"></section>
    <section class="my_model">
        <p class="title">删除宝贝<span class="closeModel">X</span></p>
        <p>您确认要删除该宝贝吗？</p>
        <div class="opBtn"><a href="javascript:;" class="dialog-sure">确定</a><a href="javascript:;" class="dialog-close">关闭</a></div>
    </section>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="js/carts.js"></script>
</div>
<!--页脚-->
<jsp:include page="include/footer.jsp"></jsp:include>

</body>
</html>
