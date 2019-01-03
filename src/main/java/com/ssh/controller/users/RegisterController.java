package com.ssh.controller.users;

import com.ssh.entity.User;
import com.ssh.service.UserService;
import com.ssh.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public ModelAndView register(User user, HttpSession session) {
        ModelMap map=new ModelMap();
        if (null == user.getUserid()){
            map.put("failReason","注册失败！用户名为空");
            return new ModelAndView("forward:register",map);
        }
        if (null == user.getName()){
            map.put("failReason","注册失败！昵称为空");
            return new ModelAndView("forward:register",map);
        }
        if (UserUtils.checkPassword(user.getPassword())){
            map.put("failReason","注册失败！密码不符合条件");
            return new ModelAndView("forward:register",map);
        }
        String password = user.getPassword();
        user.setPassword(UserUtils.getSHA256StrJava(password));
        String result = userService.register(user);
        if (result.equals("success")){
            session.setAttribute("user",user);
            return new ModelAndView("forward:mainPage");
        }
        map.put("failReason",result);
        return new ModelAndView("forward:register",map);
    }

    @RequestMapping(value = "/register",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView register() {
        return new ModelAndView("register");
    }
}
