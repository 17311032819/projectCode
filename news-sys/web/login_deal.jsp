<%@ page import="com.cdvtc.news.dao.UserDao" %>
<%@ page import="com.cdvtc.news.dao.impl.UserDaoImpl" %>
<%@ page import="com.cdvtc.news.model.User" %>
<%@ page import="com.cdvtc.news.util.Md5Util" %><%--
  Created by IntelliJ IDEA.
  User: zhao
  Date: 2021/12/19
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String account = request.getParameter("account");
    String password = request.getParameter("password");
    UserDao userDao = new UserDaoImpl();
    User user = userDao.login(account, Md5Util.md5(password)); // 注意：密码需要先进行MD5加密
    if(user != null){ //登陆成功
        session.setAttribute("user", user);
        session.setAttribute("ipAddress", request.getRemoteAddr()); // 保存登陆地址
//        response.sendRedirect("index.jsp");  //重定向至首页

        request.setAttribute("page", "index.jsp");
        request.setAttribute("pageName", "首页");
        request.getRequestDispatcher("delay_jump.jsp").forward(request, response);
    } else { //登陆失败
        request.setAttribute("error", "登陆失败!");
        request.getRequestDispatcher("login.jsp").forward(request, response); //前转(同一个request对象)至登陆页面
    }
%>
