package com.cdvtc.news.servlet.admin;

import com.cdvtc.news.dao.AdminDao;
import com.cdvtc.news.dao.impl.AdminDaoImpl;
import com.cdvtc.news.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin/admin")
public class AdminServlet extends BaseServlet {
    AdminDao adminDao = new AdminDaoImpl();
    public void list() throws ServletException, IOException {
        List<Admin> adminList = adminDao.getAllAdmins();
        request.setAttribute("adminList", adminList);

        request.getRequestDispatcher("/admin/admin-list.jsp").forward(request, response);
    }
}
