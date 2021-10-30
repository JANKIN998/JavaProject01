package com.abc.hotelsys.controller;

import com.abc.hotelsys.domain.User;
import com.abc.hotelsys.exception.HotelSysException;
import com.abc.hotelsys.service.UserService;
import com.abc.hotelsys.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SecurityController extends BaseController {

    @GetMapping("/toLogin")
    public String toLogin() throws Exception{
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session) throws Exception{

        UserService userService = new UserServiceImpl();

        try{
            user = userService.checkUser(user.getUserNo(), user.getUserPwd());
            session.setAttribute("loginedUser", user);
        }catch(HotelSysException e){
            model.addAttribute("errMsg", e.getMessage());
            return "login";
        }

        return "redirect:/main";
    }

    @GetMapping("/main")
    public String toMain() throws Exception{
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) throws Exception{
        session.removeAttribute("loginedUser");
        session.invalidate();

        return "redirect:/toLogin";
    }


}
