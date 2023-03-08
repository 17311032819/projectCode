<%--
  Created by IntelliJ IDEA.
  User: 吴健军
  Date: 2022/6/12
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>评论</title>
    <style type="text/css">
        textarea{
            width: 300px;
            height: 200px;
        }
    </style>
</head>
<body>
<%
    String ono=request.getParameter("orderno");

%>

<div>

    <form action="CommentServlet?orderno=<%=ono%>" method="post">

        <div class="form-group">
            <label>你的评论</label>
            <input type="text" name="comment" class="form-control" >
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">登陆</button>
        </div>
    </form>

</div>

</body>
</html>
