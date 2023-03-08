package com.cdvtc.ecommerce.servlet;

import com.cdvtc.ecommerce.dao.UserDao;
import com.cdvtc.ecommerce.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("nickname");
        String password=request.getParameter("password");
        String confirmPwd=request.getParameter("confirmPwd");
        String mobile=request.getParameter("mobile");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String birthday= request.getParameter("birthday");
        UserDao userDao=new UserDao();
        if (userDao.isUserExisted(email)){
            request.setAttribute("error_email", "邮箱已经存在了！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }else if(password.equals(confirmPwd)==false){
            request.setAttribute("error_password", "两次输入密码不一致！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }else {
            System.out.println(sex);
            User user=new User();
            user.setM_mail(email);
            user.setM_phone(mobile);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setM_birth(df.parse(birthday));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setM_password(password);
            user.setM_sex(sex);
            user.setM_name(name);
            if (userDao.addUser(user)){
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }


        }

    }
}
