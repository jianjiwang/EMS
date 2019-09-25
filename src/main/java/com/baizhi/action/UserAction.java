package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
//RequestMapper相当于namespace
@RequestMapping("/user")
public class UserAction {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(User user) throws Exception{
       userService.register(user);
       return "login";
    }
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session) throws Exception{
        try {
            userService.login(user);
            session.setAttribute("flag","F");
            return "redirect:/department/selectAll.do";
        }catch (Exception e) {
            String message=e.getMessage();
            model.addAttribute("message",message);
            return "login";
        }
    }
}
