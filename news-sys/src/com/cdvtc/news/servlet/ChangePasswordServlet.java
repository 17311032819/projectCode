package com.cdvtc.news.servlet;

import com.cdvtc.news.dao.UserDao;
import com.cdvtc.news.dao.impl.UserDaoImpl;
import com.cdvtc.news.model.User;
import com.cdvtc.news.util.Md5Util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", value = "/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        UserDao userDao = new UserDaoImpl();

        // 先验证旧密码是否正确
        if(userDao.login(user.getAccount(), Md5Util.md5(oldPassword)) != null) { //旧密码正确
            userDao.updatePassword(user.getAccount(), Md5Util.md5(newPassword));

            request.setAttribute("page", "index.jsp");
            request.setAttribute("message", "密码修改成功，下次请使用新密码登陆。");
            request.getRequestDispatcher("alert_jump.jsp").forward(request, response);
        } else { // 旧密码不正确
            request.setAttribute("error", "旧密码不正确！");
            request.getRequestDispatcher("change_password.jsp").forward(request, response);
        }
    }
}
