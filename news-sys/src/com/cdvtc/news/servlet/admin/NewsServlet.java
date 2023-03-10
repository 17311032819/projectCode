package com.cdvtc.news.servlet.admin;

import com.cdvtc.news.dao.CategoryDao;
import com.cdvtc.news.dao.NewsDao;
import com.cdvtc.news.dao.Page;
import com.cdvtc.news.dao.TagDao;
import com.cdvtc.news.dao.impl.CategoryDaoImpl;
import com.cdvtc.news.dao.impl.NewsDaoImpl;
import com.cdvtc.news.dao.impl.TagDaoImpl;
import com.cdvtc.news.model.Admin;
import com.cdvtc.news.model.Category;
import com.cdvtc.news.model.News;
import com.cdvtc.news.model.Tag;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "NewsServlet", value = "/admin/news")
public class NewsServlet extends BaseServlet {
    NewsDao newsDao = new NewsDaoImpl();
    CategoryDao categoryDao = new CategoryDaoImpl();
    TagDao tagDao = new TagDaoImpl();

    public void list() throws ServletException, IOException {
        int pageSize = 10;
        int pageNumer = 1;
        String page = this.request.getParameter("page");
        String size = this.request.getParameter("size");
        if(page != null) {
            pageNumer = Integer.valueOf(page);
        }
        if(size != null) {
            pageSize = Integer.valueOf(size);
        }

//        List<News> newsList = newsDao.getAllNews();

        Page<News> pagedNews = newsDao.getPagedNews(pageNumer, pageSize);

        this.request.setAttribute("pagedNews", pagedNews);
        this.request.getRequestDispatcher("/admin/news-list.jsp").forward(this.request, this.response);
    }

    public void add() throws ServletException, IOException {
        List<Category> categories = categoryDao.getAllCategories();
        List<Tag> tags = tagDao.getAllTags();
        this.request.setAttribute("categories", categories);
        this.request.setAttribute("tags", tags);
        this.request.getRequestDispatcher("/admin/news-edit.jsp").forward(this.request, this.response);
    }

    public void save() throws Exception {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(10 * 1024 * 1024); // ????????????????????????
        upload.setSizeMax(50 * 1024 * 1024); // ?????????????????????
        upload.setHeaderEncoding("UTF-8"); // ???????????????????????????

        List<FileItem> fileItemList = upload.parseRequest(request);

        Map<String, String> parameters = new HashMap<>();
        Set<Integer> tagIds = new HashSet<>(); // ?????????????????????????????????????????????????????????
        for (FileItem fileItem : fileItemList) {
            if (fileItem.isFormField()) { //????????????
                String name = fileItem.getFieldName();
                String value = fileItem.getString();
                value = new String(value.getBytes("ISO-8859-1"),
                        "UTF-8"); //????????????????????????????????????????????????
                if(name.equals("tag")) {
                    tagIds.add(Integer.valueOf(value));
                }else{
                    if (name != null) {
                        parameters.put(name, value); //???????????????????????????Map???
                    }
                }
            } else { //????????????
                if (fileItem.getSize() > 0) { //???????????????
                    String path = this.getServletContext().getRealPath("/img");  //????????????????????????????????????????????????
                    String fileName = fileItem.getName();

                    //?????????????????????????????????UUID?????????
                    UUID uuid = UUID.randomUUID();
                    File file = new File(path, uuid.toString() + fileName.substring(fileName.indexOf(".")));

                    //????????????
                    fileItem.write(file);
                    parameters.put("img", file.getName());
                }
            }
        }

        // ??????????????????????????????
        News news = new News();
        news.setEditor((Admin) this.request.getSession().getAttribute("admin")); //???????????????????????????????????????

        for (String name : parameters.keySet()) {
            switch (name) {
                case "img": {
                    news.setImg(parameters.get("img"));
                    break;
                }
                case "id": {
                    String id = parameters.get("id");
                    if(id != null && id.length()>0){  // id???????????????????????????
                        news.setId(Integer.parseInt(id));
                    }
                    break;
                }
                case "title": {
                    news.setTitle(parameters.get("title"));
                    break;
                }
                case "content": {
                    news.setContent(parameters.get("content"));
                    break;
                }
                case "stick": {
                    news.setStick(Boolean.valueOf(parameters.get("stick")));
                    break;
                }
                case "categoryId": {
                    Category category = new Category();
                    category.setId(Integer.valueOf(parameters.get("categoryId")));
                    news.setCategory(category);
                    break;
                }
            }
        }
        if (news.getId() != null) { //??????
           newsDao.updateNews(news);
           tagDao.updateTagsForNews(news.getId(), tagIds);
        } else { //??????
            if (news.getImg() == null) {
                news.setImg("news.jpg"); //??????????????????
            }
            int newsId = newsDao.addNews(news);
            tagDao.addTagsForNews(newsId, tagIds);
        }

        this.response.sendRedirect(request.getContextPath() + "/admin/news?method=list");
    }

    public void edit() throws ServletException, IOException {
        int id = Integer.valueOf(this.request.getParameter("id"));
        News news = newsDao.getNewsById(id);

        //?????????????????????????????????
        Set<Tag> tagSet = tagDao.getTagsByNewsId(id);
        Set<Integer> tagIdSet = new HashSet<>();
        for(Tag tag: tagSet){
            tagIdSet.add(tag.getId());
        }

        List<Category> categories = categoryDao.getAllCategories();
        List<Tag> tags = tagDao.getAllTags();
        this.request.setAttribute("news", news);
        this.request.setAttribute("tagIdSet", tagIdSet);
        this.request.setAttribute("categories", categories);
        this.request.setAttribute("tags", tags);
        this.request.getRequestDispatcher("/admin/news-edit.jsp").forward(this.request, this.response);
    }
}
