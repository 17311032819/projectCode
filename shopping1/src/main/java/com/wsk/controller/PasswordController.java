package com.wsk.controller;

import com.wsk.bean.OrdersBean;
import com.wsk.pojo.UserInformation;
import com.wsk.pojo.UserPassword;
import com.wsk.service.UserPasswordService;
import com.wsk.tool.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wsk.tool.StringUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class PasswordController {

    @Resource
    UserPasswordService userPasswordService;
    @RequestMapping(value = "/updata_password.do")
    public String updata_password(HttpServletRequest request, Model model) {
        UserInformation userInformation = (UserInformation) request.getSession().getAttribute("userInformation");
        if (StringUtils.getInstance().isNullOrEmpty(userInformation)) {
            userInformation = new UserInformation();
            model.addAttribute("userInformation", userInformation);
            return "redirect:/login.do";
        } else {
            model.addAttribute("userInformation", userInformation);
        }
        System.out.println("修改密码");
        return "page/personal/updata_password";
    }

    ///certification.do
    @ResponseBody
    @RequestMapping(value = "/certificationPassword.do")
    public Map certificationPassword(HttpServletRequest request,@RequestParam String password,@RequestParam String password1) {
        UserInformation userInformation = (UserInformation) request.getSession().getAttribute("userInformation");
        Map<String, Integer> map = new HashMap<>();
        UserPassword sqlPassword=userPasswordService.selectByUid(userInformation.getId());
        if (password1.length()<9){
            map.put("result", 0);
            return map;
        }else {


            if (!StringUtils.getInstance().getMD5(password).equals(sqlPassword.getPassword())){
                //原密码错误
                System.out.println(StringUtils.getInstance().getMD5(password).equals(sqlPassword.getPassword()));
                map.put("result", 1);
                return map;
            }
        }
        request.getSession().setAttribute("userInformation", userInformation);
        String passwordnewMD5=StringUtils.getInstance().getMD5(password1);
        System.out.println(passwordnewMD5);
        sqlPassword.setPassword(passwordnewMD5);
        sqlPassword.setModified(new Date());
        userPasswordService.updateByUid(sqlPassword);
        map.put("result", 2);
        return map;
    }
}
