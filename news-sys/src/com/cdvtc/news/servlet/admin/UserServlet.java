package com.cdvtc.news.servlet.admin;

import com.cdvtc.news.dao.UserDao;
import com.cdvtc.news.dao.impl.UserDaoImpl;
import com.cdvtc.news.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/admin/user")
public class UserServlet extends BaseServlet {
    UserDao userDao = new UserDaoImpl();
    public void list() throws ServletException, IOException {
        List<User> userList = userDao.getAllUsers();
        request.setAttribute("userList", userList);

        request.getRequestDispatcher("/admin/user-list.jsp").forward(request, response);
    }

    public void forbidden() throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        boolean forbidden = Boolean.valueOf(request.getParameter("forbidden"));
        userDao.forbiddenUser(id, forbidden);

        this.list();  // 调用显示列表方法(重用代码）
    }
}
