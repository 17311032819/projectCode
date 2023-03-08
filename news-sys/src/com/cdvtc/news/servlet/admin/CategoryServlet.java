package com.cdvtc.news.servlet.admin;

import com.cdvtc.news.dao.CategoryDao;
import com.cdvtc.news.dao.impl.CategoryDaoImpl;
import com.cdvtc.news.model.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/admin/category")
public class CategoryServlet extends BaseServlet {
    CategoryDao categoryDao = new CategoryDaoImpl();

    public void list() throws ServletException, IOException {
        List<Category> categoryList = categoryDao.getAllCategories();
        this.request.setAttribute("categoryList", categoryList);

        this.request.getRequestDispatcher("/admin/category-list.jsp").forward(this.request, this.response);
    }
}
