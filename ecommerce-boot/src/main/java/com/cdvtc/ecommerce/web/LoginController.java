package com.cdvtc.ecommerce.web;

import com.cdvtc.ecommerce.model.User;
import com.cdvtc.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String index() {
        return "login";
    }

//    @PostMapping("/login")
//    public String login(String email, String password, Model model, HttpSession session) {
//        User user = userRepository.getUserByEmailAndPassword(email, password);
//        if(user != null) {
//            session.setAttribute("auth", user);
//            return "redirect:/";
//        } else {
//            model.addAttribute("error", "账户或密码错误。");
//            return "login";
//        }
//    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
