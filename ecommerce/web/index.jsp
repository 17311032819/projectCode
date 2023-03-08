<%@ page import="com.cdvtc.ecommerce.dao.ProductDao" %>
<%@ page import="com.cdvtc.ecommerce.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cdvtc.ecommerce.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: 吴健军
  Date: 2022/6/2
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主界面</title>
    <style type="text/css">
        #main_link>ul{
            width:1400px;
            margin: 0 auto;
            overflow:hidden;
            margin-top:-40px;}
        #main_link>ul>a{
            float:left;
            font-size: 15px;
        }
        #main_link>ul>a>li{
            width:92px;
            height:63px;
            background:url(images/sprite.png) no-repeat -22px 0px;}
        #main_link>ul{
            float:left;
            overflow:hidden;
        }
        #main_link>ul>li{
            float:left;
            margin-top:25px;
            margin-right:100px;

        }

        #main_link>ul>li>a{
            font-size:15px;
            color:#4c4c4c;
        }
        #main_link>ul>li>a:hover{
            color:#fb0000;}
        #main_link>ul>li>.first{
            color:#fb0000;}
        #main_link>ul>.search{
            margin-top:20px;
            margin-left:90px;}
        #main_link>ul>.search>input{
            width:254px;
            height:30px;
            border:1px solid #fb0000;
            border-radius:20px;
            outline:none;
            color:#999;
            padding-left:16px;
            font-size:16px;}
        #main_link>ul>.search>button{
            width:29px;
            height:29px;
            background:url(images/sprite.png) no-repeat -115px 0px;
            border:none;
            vertical-align:middle;
        }
        .taday img{
            height: 300px;
            width: 250px;

        }
        div.goods{
            float: left;
            width: 350px;
            height: 560px;
            margin-left: 50px;
        }
        a{
            text-decoration: none;
        }
        div.buyandcar{
            width: 500px;
            height: 200px;
        }

        div.buyandcar a.buy{
            clear: both;
            width:110px;
            height:35px;
            background:#fb0000;
            color:#fff;
            line-height:35px;
            text-align:center;
            font-size:18px;
            border-radius:8px;
            float: left;
        }

        div.buyandcar a.car{
            float: left;
            width:110px;
            height:35px;
            border:1px solid #fb0000;
            color:#fb0000;
            line-height:35px;
            text-align:center;
            font-size:18px;
            border-radius:8px;
            margin-left: 10px;
        }



    </style>
</head>
<body>
<%@include file="include/header.jsp"%>

<%
    //获取分类和标签参数
    String category1=request.getParameter("category");
    String id =  request.getParameter("id");
    ProductDao productDao=new ProductDao();
    List<Category> categoryList=productDao.getAllCategories();

    List<Product> todayproductList=productDao.gettodaycommend();
%>

<div id="main_link">

    <ul style="list-style: none">
            <%for(Category category: categoryList) {%>
            <li <%if(String.valueOf(category.getC_no()).equalsIgnoreCase(id)) {%>class="active"<%}%>><a href="index.jsp?id=<%=category.getC_no()%>"><h3><%=category.getC_name()%></h3></a></li>
            <%}%>

        <li class="search">
            <input value="洗衣液">
            <button></button>
        </li>

    </ul>
</div>
<div class="taday">
    <div class="today">


        <div class="refine">
            <h2>&nbsp;&nbsp;&nbsp;今日推荐</h2>
        </div>
        <%for(Product product: todayproductList) {%>
        <div class="goods">

            <div class="today">
                <a href="xiangqing.jsp?g_no=<%=product.getG_no()%>"><img width="200px" height="200px" src="images/<%=product.getG_no()%>/<%=product.getMain_image()%>"
                     ></a>
                <div class="card-body">
                    <h3 class="card-title"><%=product.getG_name() %>
                    </h3>
                    <h4>价格: ￥<%=product.getG_price() %>
                    </h4>
                    <h4>类别: <%=product.getCategory().getC_name() %>
                    </h4>
                    <h4>量: <%=product.getG_quantity() %>
                    </h4>
                    <div class="buyandcar">
                        <a href="pay.jsp" class="buy">立刻购买</a>
                        <a href="shoppingCar.jsp" class="car">加入购物车</a>
                        <a href="#" class="love"></a>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</div>

<%@include file="/include/footer.jsp" %>

</body>
</html>