package com.cdvtc.ecommerce.servlet;

import com.cdvtc.ecommerce.connection.DbCon;
import com.cdvtc.ecommerce.dao.UserDao;
import com.cdvtc.ecommerce.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("login-email");
        String password = request.getParameter("login-password");

        UserDao dao = new UserDao();
        User user = dao.userLogin(email, password);
        if (user != null) {
            request.getSession().setAttribute("auth", user);
//				System.out.print("user logged in");
            response.sendRedirect("index.jsp");
        } else {
            out.println("ÓÃ»§µÇÂ½Ê§°Ü!");
        }
    }
}
