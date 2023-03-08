<%@ page import="com.cdvtc.ecommerce.dao.OrderDao" %>
<%@ page import="com.cdvtc.ecommerce.model.Order" %>
<%@ page import="com.cdvtc.ecommerce.dao.ProductDao" %><%--
  Created by IntelliJ IDEA.
  User: 吴健军
  Date: 2022/6/12
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <style type="text/css">

        div.stateRsult{
            border: 2px solid  #28a745;
            height: 250px;
            margin-bottom: 30px;

        }
        div.stateDetails{
            border: 2px solid  #28a745;
            height: 250px;
            margin-bottom: 30px;
        }
        div.stateRsult_left{
            padding-top: 40px;
            padding-left: 100px;
            float: left;
        }
        div.stateRsult_right{
            float: left;
        }
        div.stateRsult_right li{
            margin-top: 60px;
            margin-left: 300px;
        }
        div.stateDetails img{
            width: 130px;
            height: 130px;
            float: left;
            margin-left: 50px;
            margin-top: 30px;
        }
        div.method{
            margin-top: 50px;
            margin-left: 15px;
            float: left;
            list-style: none;
        }

        div.stateDetail_right {
            float: left;
        }
        div.stateDetail_right{
            padding-left: 200px;
            margin-top: 50px;
            list-style: none;
            float: left;
        }
        a{
            text-decoration: none;
            color: black;
        }
        a:hover{
            color: red;
        }
        div.comment{
            padding-left: 100px;
            margin-top: 20px;
            float: left;



        }
        div.comment a{
            clear: both;
            width:110px;
            height:35px;
            background: #95999c;
            color:black;
            line-height:35px;
            text-align:center;
            font-size:18px;
            border-radius:8px;
            float: left;
        }

    </style>
</head>
<body>
<%
    String o_no=request.getParameter("orderno");
    OrderDao orderDao=new OrderDao();
    Order order=orderDao.getOrderByo_no(o_no);
    ProductDao productDao=new ProductDao();

%>

<p>一点超市>我的订单>订单:<%=o_no%></p>
<div class="state">
    <div class="stateRsult">
        <div class="stateRsult_left">
            <p>订单号:<%=o_no%></p>
            <font color="#28a745" size="20px"><%=order.getO_state()%></font>
        </div>
        <div class="stateRsult_right">
            <li>提交订单：<%=order.getDate()%></li>
        </div>
    </div>
    <div class="stateDetails">
        <div class="stateDetail_left">

                <img src="images/<%=order.getG_no() %>/<%=productDao.getProductByGno(order.getG_no()).getMain_image()%>">
            <div class="method">
                <li><a href="xiangqing.jsp?g_no=<%=order.getG_no()%>">商品名字: <%=order.getG_name()%></a></li>
                <li></li>
                <li>收货地址:<%=order.getAdress()%></li>
                <li>配送方式:顺丰快递</li>
                <li>承运人:一点超市</li>
                <li>订单号:<%=o_no%></li>
            </div>

        </div>
        <div class="stateDetail_right">
            <li>下单时间: <%=order.getDate()%></li>
            <li>单价: <%=order.getPrice()%></li>
            <li>数量: <%=order.getNumber()%></li>
            <li>总价:  <%= order.getPrice()*order.getNumber()%></li>
        </div>
        <div class="comment">
            <%
                String state=order.getO_state();
                if (state.equals("配送成功")==false){
                    String comment=order.getComment();
                    if (comment.equals(null)||comment.equals("")){%>
            <a href="comment.jsp?orderno=<%=o_no%>">评论</a>
            <%}else {%>
            评论：
            <p><%=comment%></p>
               <% }}else {%>
            <p><%=order.getComment()%></p>
               <% }
            %>

        </div>
    </div>

</div>
</body>
</html>
