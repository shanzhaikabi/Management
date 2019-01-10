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

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class EditCharacterController {
    @Autowired
    UserService userService;

    @Autowired
    CharacterService characterService;

    @RequestMapping(value = "addcharacter",method = {RequestMethod.GET,RequestMethod.POST})
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
        Chara character = new Chara();
        map.put("character",character);
        map.put("isnew",true);
        List<Operation> list = characterService.getOperationByCharacter(character);
        List<Operation> operations = characterService.showOperations();
        map.put("operationList", CharacterUtils.getOperations(list,operations));
        return new ModelAndView("editCharacter",map);
    }

    @RequestMapping(value = "showcharlist",method = {RequestMethod.GET,RequestMethod.POST})
    ModelAndView showCharacters(HttpSession session,Chara character){
        ModelMap map = new ModelMap();
        User user = (User) session.getAttribute("user");
        if (null == user){//登陆失效
            return new ModelAndView("login");
        }
        if (userService.notHaveOperation(user,2)){
            map.put("result","您没有此权限");
            return new ModelAndView("mainPage",map);
        }
        List<Object[]> list = characterService.showCharacters();
        map.put("charList",CharacterUtils.showCharacterDetail(list));
        return new ModelAndView("showCharacters",map);
    }

    @RequestMapping(value = "editchar",method = {RequestMethod.GET,RequestMethod.POST})
    ModelAndView showCharacter(HttpSession session, Integer id){
        ModelMap map = new ModelMap();
        User user = (User) session.getAttribute("user");
        if (null == user){//登陆失效
            return new ModelAndView("login");
        }
        if (userService.notHaveOperation(user,2)){
            map.put("result","您没有此权限");
            return new ModelAndView("mainPage",map);
        }
        Chara character = characterService.get(id);
        map.put("character",character);
        List<Operation> list = characterService.getOperationByCharacter(character);
        List<Operation> operations = characterService.showOperations();
        map.put("operationList", CharacterUtils.getOperations(list,operations));
        return new ModelAndView("editCharacter",map);
    }

    @RequestMapping(value = "editCharacter.do",method = RequestMethod.POST)
    ModelAndView editCharacter(Chara character,@RequestParam("operations") String[] operations,@RequestParam("isnew") String isnew){
        ModelMap map = new ModelMap();
        if (isnew != null){
            System.out.println("save!!!" + characterService.save(character));
        }
        characterService.updateCharacter(character,operations);
        map.put("result","修改成功");
        return new ModelAndView("mainPage");
    }
}
