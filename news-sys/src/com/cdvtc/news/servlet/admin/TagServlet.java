package com.cdvtc.news.servlet.admin;

import com.cdvtc.news.dao.TagDao;
import com.cdvtc.news.dao.impl.TagDaoImpl;
import com.cdvtc.news.model.Tag;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TagServlet", value = "/admin/tag")
public class TagServlet extends BaseServlet {
    TagDao tagDao = new TagDaoImpl();

    public void list() throws ServletException, IOException {
        List<Tag> tagList = tagDao.getAllTags();
        this.request.setAttribute("tagList", tagList);

        this.request.getRequestDispatcher("/admin/tag-list.jsp").forward(this.request, this.response);
    }
}
