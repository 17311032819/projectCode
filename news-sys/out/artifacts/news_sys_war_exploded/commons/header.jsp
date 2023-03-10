<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cdvtc.news.dao.CategoryDao" %>
<%@ page import="com.cdvtc.news.dao.impl.CategoryDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cdvtc.news.model.Category" %><%--
  Created by IntelliJ IDEA.
  User: zhao
  Date: 2021/12/15
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    CategoryDao categoryDao = new CategoryDaoImpl();
    List<Category> categories = categoryDao.getAllCategories();
%>
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="index.html" class="navbar-brand"></a>
        </div>
        <!-- class="visible-xs-inline-block"：在超小屏幕上显示-->
        <label for="toggle-checkbox" id="toggle-label" class="visible-xs-inline-block">菜单</label>
        <input type="checkbox" class="hidden" id="toggle-checkbox">
        <div class="hidden-xs">
            <ul class="nav navbar-nav">

                <%
                    String categoryId = request.getParameter("category");
                %>
                <li <%if(categoryId==null){%>class="active"<%}%>><a href="index.jsp">首页</a></li>
                <%for (Category category : categories) {%>
                <li <%if(categoryId!=null && category.getId()==Integer.valueOf(categoryId)){%>class="active"<%}%>><a
                        href="index.jsp?category=<%=category.getId()%>"><%=category.getName()%>
                </a></li>
                <%}%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${not empty sessionScope.user}">
                    <li><a href="#"><img src="img/photos/${sessionScope.user.photo}" class="img-circle" width="32px"></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">${sessionScope.user.nickname}<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="userinfo.jsp">个人信息</a></li>
                            <li><a href="change_password.jsp">修改密码</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="javascript:logout()">退出</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${empty sessionScope.user}">
                    <li><a href="login.jsp">登陆</a></li>
                </c:if>

                <li><a href="signup.jsp">注册</a></li>
            </ul>
        </div>
    </div>
</div>
<script>
    function logout() {
        if(confirm("您确定定要退出吗？")){
            window.location.href = "logout.jsp"; //前端页面跳转
        }
    }
</script>
