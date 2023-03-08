<%--
  Created by IntelliJ IDEA.
  User: zhao
  Date: 2021/12/18
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>系统出现异常</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/main.css">
</head>
<body>
<div class="alert-warning">
    <h4>系统出现异常（错误码：<%=response.getStatus()%>）：</h4>
    <p><%=exception.getLocalizedMessage()%></p>
</div>
</body>
</html>
