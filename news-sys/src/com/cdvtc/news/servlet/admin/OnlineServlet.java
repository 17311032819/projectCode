package com.cdvtc.news.servlet.admin;

import com.cdvtc.news.listener.SessionListener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OnlineServlet", value = "/admin/online")
public class OnlineServlet extends BaseServlet {
    public void list() throws ServletException, IOException {
        request.setAttribute("onlineUserMap", SessionListener.onlineUserMap);
        request.getRequestDispatcher("/admin/online.jsp").forward(request, response);
    }

    public void offline() throws IOException {

        String sessionId = request.getParameter("sid"); //获取会话Id

        for(HttpSession session: SessionListener.onlineUserMap.keySet()){
            if(session.getId().equals(sessionId)) {
                session.invalidate(); // 强制会话失效(强退）
                break;
            }
        }

        response.sendRedirect(request.getContextPath() + "/admin/online");
    }
}
