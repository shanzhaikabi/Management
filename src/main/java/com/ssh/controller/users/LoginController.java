package com.ssh.controller.users;

import com.ssh.entity.User;
import com.ssh.service.UserService;
import com.ssh.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ModelAndView login(HttpServletResponse httpServletResponse, HttpSession session, User user, String isUseCookie){
        if (null == isUseCookie){
            httpServletResponse.addCookie(new Cookie("username",null));
            httpServletResponse.addCookie(new Cookie("password",null));
        }
        String password = user.getPassword();
        user.setPassword(UserUtils.getSHA256StrJava(password));
        ModelMap map = new ModelMap();
        if (null == user.getUserid()){
            map.put("failReason","登陆失败,请检查账号或密码");
            return new ModelAndView("login",map);
        }
        if (userService.login(user).equals("success")){//登陆成功
            if (null != isUseCookie && isUseCookie.length() > 0){
                httpServletResponse.addCookie(new Cookie("username",user.getUserid()));
                httpServletResponse.addCookie(new Cookie("password",password));
            }
            session.setAttribute("user",user);
        }
        else{
            httpServletResponse.addCookie(new Cookie("password",null));
            httpServletResponse.addCookie(new Cookie("username",null));
            map.put("failReason","登陆失败,请检查账号或密码");
            return new ModelAndView("login",map);
        }
        return new ModelAndView("mainPage");
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView loginWhenHaveCookie(@CookieValue(value = "username",defaultValue = "") String userName,@CookieValue(value = "password",defaultValue = "") String password) throws IOException {
        ModelMap map=new ModelMap();
        User user = new User();
        user.setUserid(userName);
        user.setPassword(password);
        map.put("user",user);
        return new ModelAndView("login",map);
    }
}
