package com.ssh.service;

import com.ssh.entity.Character;
import com.ssh.respository.CharacterRepository;
import com.ssh.respository.CharacterFunctionOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterFunctionOperationRepository cfoRepository;

    public void saveOrUpdateCharacter(Character character,String[] operations){
        characterRepository.saveOrUpdate(character);
        cfoRepository.saveOperationForCharacter(character,operations);
    }

    public boolean notHaveOperation(Character character,Long operationId){
        return cfoRepository.notHaveOperation(character,operationId);
    }

    public List<Character> showCharacters(){
        return characterRepository.findAll();
    }
}
