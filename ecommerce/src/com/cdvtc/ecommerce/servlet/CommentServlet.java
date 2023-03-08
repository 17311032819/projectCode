package com.cdvtc.ecommerce.servlet;

import com.cdvtc.ecommerce.dao.AddComment;
import com.cdvtc.ecommerce.dao.UserDao;
import com.cdvtc.ecommerce.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CommentServlet", value = "/CommentServlet")
public class CommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String orderno = request.getParameter("orderno");
        String comment = request.getParameter("comment");
        System.out.println(comment);
        AddComment addComment=new AddComment();
        System.out.println( addComment.updateComment(orderno,comment));
        if (addComment.updateComment(orderno,comment)){
            response.sendRedirect("orderDetails.jsp?orderno="+orderno);
        }else {

        }
        }
}
