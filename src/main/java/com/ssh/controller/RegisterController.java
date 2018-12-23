package com.ssh.controller;

import com.ssh.entity.User;
import com.ssh.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public ModelAndView register(User user){
        return userService.register(user);
    }
}
