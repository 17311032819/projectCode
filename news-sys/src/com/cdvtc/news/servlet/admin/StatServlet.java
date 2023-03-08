package com.cdvtc.news.servlet.admin;

import com.cdvtc.news.dao.NewsDao;
import com.cdvtc.news.dao.impl.NewsDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StatServlet", value = "/admin/stat")
public class StatServlet extends BaseServlet implements SingleThreadModel{  //特别注意：多个方法共用Servlet有线程安全问题
    NewsDao newsDao = new NewsDaoImpl();

    /**
     * 向客户端返回JSON数据
     * @param statsList
     * @throws IOException
     */
    private void writeJson(List<Map<String, Object>> statsList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("text/json;charset=UTF-8");  //设置返回类型，JSON格式

        String json = objectMapper.writeValueAsString(statsList);  // 将Java对象转为JSON字符串
        Writer out = response.getWriter();
        out.write(json);

        out.flush();
        if(out != null) {
            out.close();
        }
    }

    public void newsCountByCategory() throws IOException {
        List<Map<String, Object>> statsList = newsDao.statNewsCountByCategory();

        writeJson(statsList);
    }

    public void newsCountByTag() throws IOException {
        List<Map<String, Object>> statsList = newsDao.statNewsCountByTag();

        writeJson(statsList);
    }


    public void newsCommentCountByDate() throws IOException {
        List<Map<String, Object>> statsList = newsDao.statNewsCommentCountByDate();

        writeJson(statsList);
    }

    public void newsCommentCountByUser() throws IOException {
        List<Map<String, Object>> statsList = newsDao.statNewsCommentCountByUser();

        writeJson(statsList);
    }
}
