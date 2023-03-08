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
        upload.setFileSizeMax(10 * 1024 * 1024); // 单个文件大小限制
        upload.setSizeMax(50 * 1024 * 1024); // 总文件大小限制
        upload.setHeaderEncoding("UTF-8"); // 对中文文件编码处理

        List<FileItem> fileItemList = upload.parseRequest(request);

        Map<String, String> parameters = new HashMap<>();
        Set<Integer> tagIds = new HashSet<>(); // 保存标签编号集合（可能会上传多个标签）
        for (FileItem fileItem : fileItemList) {
            if (fileItem.isFormField()) { //普通表单
                String name = fileItem.getFieldName();
                String value = fileItem.getString();
                value = new String(value.getBytes("ISO-8859-1"),
                        "UTF-8"); //必须进行转码，否则会出现中文乱码
                if(name.equals("tag")) {
                    tagIds.add(Integer.valueOf(value));
                }else{
                    if (name != null) {
                        parameters.put(name, value); //将获取参数写入参数Map中
                    }
                }
            } else { //上传文件
                if (fileItem.getSize() > 0) { //文件不为空
                    String path = this.getServletContext().getRealPath("/img");  //获取图片存储路径（服务器端目录）
                    String fileName = fileItem.getName();

                    //为避免文件名重复，使用UUID文件名
                    UUID uuid = UUID.randomUUID();
                    File file = new File(path, uuid.toString() + fileName.substring(fileName.indexOf(".")));

                    //写入文件
                    fileItem.write(file);
                    parameters.put("img", file.getName());
                }
            }
        }

        // 将表单参数写入数据库
        News news = new News();
        news.setEditor((Admin) this.request.getSession().getAttribute("admin")); //以当前登陆用户作为新闻编辑

        for (String name : parameters.keySet()) {
            switch (name) {
                case "img": {
                    news.setImg(parameters.get("img"));
                    break;
                }
                case "id": {
                    String id = parameters.get("id");
                    if(id != null && id.length()>0){  // id在新增时为空字符串
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
        if (news.getId() != null) { //更新
           newsDao.updateNews(news);
           tagDao.updateTagsForNews(news.getId(), tagIds);
        } else { //新增
            if (news.getImg() == null) {
                news.setImg("news.jpg"); //使用默认图片
            }
            int newsId = newsDao.addNews(news);
            tagDao.addTagsForNews(newsId, tagIds);
        }

        this.response.sendRedirect(request.getContextPath() + "/admin/news?method=list");
    }

    public void edit() throws ServletException, IOException {
        int id = Integer.valueOf(this.request.getParameter("id"));
        News news = newsDao.getNewsById(id);

        //获取新闻的标签编号集合
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
