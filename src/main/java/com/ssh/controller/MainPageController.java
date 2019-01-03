package com.ssh.controller;

import com.ssh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainPageController {
    @RequestMapping(value = "mainPage",method = {RequestMethod.GET, RequestMethod.POST})
    ModelAndView showMainPage(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (null == user){//登陆失效
            return new ModelAndView("login");
        }
        ModelMap map = new ModelMap();
        map.put("user",user);
        return new ModelAndView("mainPage",map);
    }
}
