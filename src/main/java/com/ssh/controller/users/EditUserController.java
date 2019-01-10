package com.ssh.controller.users;

import com.ssh.entity.User;
import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class EditUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "edituser.do",method = RequestMethod.POST)
    ModelAndView editUserDoIt(HttpSession session, User user,String target){
        ModelMap map = new ModelMap();
        String ret = userService.editUser(user);
        if (target == null)
            session.setAttribute("user",user);
        map.put("result",ret);
        return new ModelAndView("forward:edituser",map);
    }

    @RequestMapping(value = "edituser",method = {RequestMethod.GET,RequestMethod.POST})
    ModelAndView editUser(HttpSession session,String target){
        ModelMap map = new ModelMap();
        User user = (User) session.getAttribute("user");
        if (null == user){//登陆失效
            return new ModelAndView("login");
        }
        if (target != null && !user.getUserid().equals(target)){
            if (userService.notHaveOperation(user,6)){
                map.put("result","您没有此权限");
                return new ModelAndView("mainPage",map);
            }
            user = userService.getUserById(target);
            map.put("target",target);
        }
        map.put("user",user);
        return new ModelAndView("editUser",map);
    }
}
