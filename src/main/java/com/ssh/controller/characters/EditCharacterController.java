package com.ssh.controller.characters;

import com.ssh.entity.Character;
import com.ssh.entity.User;
import com.ssh.service.CharacterService;
import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class EditCharacterController {
    @Autowired
    UserService userService;

    @Autowired
    CharacterService characterService;

    @RequestMapping(value = "/addCharacter.do")
    ModelAndView addCharacter(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (null == user){//登陆失效
            return new ModelAndView("login");
        }
        ModelMap map = new ModelMap();
        if (userService.notHaveOperation(user,1)){
            map.put("result","您没有此权限");
            return new ModelAndView("mainPage",map);
        }
        Character character = new Character();
        character.setCharacterid((int) (new Date().getTime() % 19260817));
        map.put("character",character);
        return new ModelAndView("editCharacter",map);
    }

    @RequestMapping(value = "editCharacter")
    ModelAndView showCharacter(HttpSession session,Character character){
        User user = (User) session.getAttribute("user");
        if (null == user){//登陆失效
            return new ModelAndView("login");
        }
        ModelMap map = new ModelMap();
        map.put("character",character);
        return new ModelAndView("editCharacter",map);
    }

    @RequestMapping(value = "/editCharacter.do",method = RequestMethod.POST)
    ModelAndView editCharacter(HttpSession session,Character character,String[] operations){
        ModelMap map = new ModelMap();
        User user = (User) session.getAttribute("user");
        if (null == user){//登陆失效
            return new ModelAndView("login");
        }
        characterService.saveOrUpdateCharacter(character,operations);
        map.put("result","修改成功");
        return new ModelAndView("mainPage");
    }
}
