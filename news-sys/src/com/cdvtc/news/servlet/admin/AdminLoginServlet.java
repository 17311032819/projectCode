package com.cdvtc.news.servlet.admin;

import com.cdvtc.news.dao.AdminDao;
import com.cdvtc.news.dao.impl.AdminDaoImpl;
import com.cdvtc.news.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/admin/login")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        AdminDao adminDao = new AdminDaoImpl();
        Admin admin = adminDao.login(account, password);
        if (admin != null) { //登陆成功
            request.getSession().setAttribute("admin", admin);

            // 处理记住密码
            if ("yes".equals(remember)) {
                Cookie cookie = new Cookie("adminLogin", account+"::"+password);
                cookie.setMaxAge(60 * 60 * 24 * 30); //失效时间为30天
                response.addCookie(cookie); //向用户浏览器发送Cookie，下次请求时生效
            }

            String rootPath = request.getContextPath(); //获取项目根目录的绝对路径
            response.sendRedirect(rootPath + "/admin/index.jsp");
        } else { //登陆失败
            request.setAttribute("error", "账户或密码错误！");
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
    }
}
