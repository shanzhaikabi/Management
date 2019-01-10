package com.ssh.utils;

import com.ssh.entity.Character;
import com.ssh.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CharacterUtils {
    @Autowired
    CharacterService characterService;

    public String getCharacters(List<Character> list){
        List<Character> characters = characterService.showCharacters();
        String str = "";
        for (Character character : characters) {
            str += showCharacter(character,list.contains(character));
        }
        return str;
    }

    public String showCharacter(Character character,boolean checked){
        String str = "<input type = \"chackbox\" name = \"characters\" value = \"" + character.getCharacterid() + "\"";
        if (checked) str += "checked = \"checked\"";
        str += ">" + character.getName() + "</input>";
        return str;
    }
}
