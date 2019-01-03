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

@Controller
public class EditUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "edituser.do",method = RequestMethod.POST)
    ModelAndView editUserBySelf(HttpSession session, User user,String username){
        User target;
        if (null == username){//修改自己的信息
            target = (User) session.getAttribute("user");
            if (null == target){//登陆失效
                return new ModelAndView("redirect:login");
            }
        }
        else{
            target = userService.getUserById(username);
            if (null == target){//登陆失效
                //TODO 返回管理端
                return new ModelAndView("redirect:login");
            }
        }
        ModelMap map = new ModelMap();
        String ret = userService.editUser(user,target);
        session.setAttribute("user",user);
        map.put("result",ret);
        return new ModelAndView("forward:edituser",map);
    }

    @RequestMapping(value = "edituser",method = RequestMethod.POST)
    ModelAndView editUser(User user){
        ModelMap map = new ModelMap();
        map.put("user",user);
        return new ModelAndView("editUser",map);
    }
}
