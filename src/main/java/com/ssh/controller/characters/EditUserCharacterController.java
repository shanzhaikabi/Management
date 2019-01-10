package com.ssh.controller.characters;

import com.ssh.entity.Chara;
import com.ssh.entity.Operation;
import com.ssh.entity.User;
import com.ssh.service.CharacterService;
import com.ssh.service.UserService;
import com.ssh.utils.CharacterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EditUserCharacterController {
    @Autowired
    UserService userService;
    @Autowired
    CharacterService characterService;

    @RequestMapping(value = "showuserlist",method = {RequestMethod.GET,RequestMethod.POST})
    ModelAndView showCharacters(HttpSession session, Chara character){
        ModelMap map = new ModelMap();
        User user = (User) session.getAttribute("user");
        if (null == user){//登陆失效
            return new ModelAndView("login");
        }
        List<Object[]> list = userService.showUsers();
        map.put("userList", CharacterUtils.showUserDetail(list));
        return new ModelAndView("showUsers",map);
    }

    @RequestMapping(value = "edituserchar",method = {RequestMethod.POST,RequestMethod.GET})
    ModelAndView editUserChar(HttpSession session, String id){
        ModelMap map = new ModelMap();
        User user = (User) session.getAttribute("user");
        if (null == user){//登陆失效
            return new ModelAndView("login");
        }
        if (userService.notHaveOperation(user,4)){
            map.put("result","您没有此权限");
            return new ModelAndView("mainPage",map);
        }
        User target = userService.getUserById(id);
        map.put("user",target);
        List<Chara> list = userService.getCharactersByUser(target);
        List<Chara> charas = characterService.showCharactersForUser();
        map.put("charList", CharacterUtils.getCharacters(list,charas));
        return new ModelAndView("editUserChar",map);
    }

    @RequestMapping(value = "edituserchar.do",method = RequestMethod.POST)
    ModelAndView editUserCharDoIt(User user,@RequestParam(value = "characters",defaultValue = "") String[] characters){
        List<Integer> list = new ArrayList<>();
        if (characters != null)
        for (String character : characters) {
            list.add(Integer.valueOf(character));
        }
        userService.editUserChar(user,list);
        ModelMap map = new ModelMap();
        map.put("result","修改成功");
        return new ModelAndView("mainPage",map);
    }
}
