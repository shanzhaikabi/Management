package com.ssh.controller;

import com.ssh.entity.User;
import com.ssh.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public ModelAndView register(HttpServletResponse httpServletResponse, User user) {
        ModelAndView ret = userService.register(user);
        if (ret.getViewName().equals("mainPage")){
            httpServletResponse.addCookie(new Cookie("userid",user.getUserid()));
        }
        else{
            httpServletResponse.addCookie(new Cookie("userid",null));
        }
        return ret;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("register");
    }
}
