package com.ssh.utils;

import com.ssh.entity.Chara;
import com.ssh.entity.Operation;
import com.ssh.entity.User;
import com.ssh.service.CharacterService;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UtilityClass
public class CharacterUtils {

    public String getCharacters(List<Chara> list,List<Chara> characters){
        String str = "";
        for (Chara character : characters) {
            str += showCharacter(character,list.contains(character));
        }
        return str;
    }

    public String showCharacter(Chara character, boolean checked){
        String str = "<input type = \"checkbox\" name = \"characters\" value = \"" + character.getCharacterid() + "\"";
        if (checked) str += "checked = \"checked\"";
        str += ">" + character.getName();
        str += "</input>";
        return str;
    }
    public String getOperations(List<Operation> list,List<Operation> operations){
        String str = "";
        for (Operation operation : operations) {
            str += showOperation(operation,list.contains(operation));
        }
        return str;
    }

    public String showOperation(Operation operation,boolean checked){
        String str = "<input type = \"checkbox\" name = \"operations\" value = \"" + operation.getOperationid() + "\"";
        if (checked) str += " checked = \"checked\"";
        str += ">" + operation.getName() + "</input>";
        return str;
    }

    public String showCharacterDetailForOne(Object[] objects){
        Chara character = (Chara) objects[0];
        String str = "<fieldset><legend>" + character.getName() + "</legend>";
        List<Operation> operations = (List<Operation>) objects[1];
        for (Operation operation : operations) {
            str += operation.getName() + "<br>";
        }
        str += "<a href=\"editchar?id=" + character.getCharacterid() + "\"> 修改 </a><br>";
        str += "<a href=\"delchar?id=" + character.getCharacterid() + "\"> 删除 </a><br>";
        str += "</fieldset>";
        return str;
    }

    public String showCharacterDetail(List<Object[]> list){
        String str = "";
        for (Object[] objects : list) {
            str += showCharacterDetailForOne(objects);
        }
        return str;
    }

    public String showUserDetail(List<Object[]> list){
        String str = "";
        for (Object[] objects : list) {
            str += showUserDetailForOne(objects);
        }
        return str;
    }

    public String showUserDetailForOne(Object[] objects){
        User user = (User) objects[0];
        String str = "<fieldset><legend>" + user.getName() + "</legend>";
        List<Chara> characters = (List<Chara>) objects[1];
        for (Chara character : characters) {
            str += character.getName() + "<br>";
        }
        //str += "<a href=\"edituser?id=" + user.getUserid() + "\"> 修改信息 </a><br>";
        str += "<a href=\"edituserchar?id=" + user.getUserid() + "\"> 修改权限 </a><br>";
        str += "</fieldset>";
        return str;
    }
}
