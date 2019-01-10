package com.ssh.service;

import com.ssh.entity.Chara;
import com.ssh.entity.Operation;
import com.ssh.respository.CharacterRepository;
import com.ssh.respository.CharacterFunctionOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterFunctionOperationRepository cfoRepository;

    public void updateCharacter(Chara character, String[] operations){
        characterRepository.saveOrUpdate(character);
        cfoRepository.saveOperationForCharacter(character,operations);
    }

    public boolean notHaveOperation(Chara character, Integer operationId){
        return cfoRepository.notHaveOperation(character,operationId);
    }

    public List<Object[]> showCharacters(){
        List<Chara> list = characterRepository.findAll();
        List<Object[]> finalList = list.stream().map(chara -> {
            List<Operation> operations = cfoRepository.getOperationByCharacter(chara);
            Object[] objects = new Object[]{chara,operations};
            return objects;
        }).collect(Collectors.toList());
        return finalList;
    }

    public List<Chara> showCharactersForUser(){
        return characterRepository.findAll();
    }

    public List<Operation> showOperations(){
        return characterRepository.findAllOperation();
    }

    public List<Operation> getOperationByCharacter(Chara character){
        return cfoRepository.getOperationByCharacter(character);
    }

    public Integer save(Chara character){
        return characterRepository.save(character);
    }

    public Chara get(Integer id){
        return characterRepository.get(id);
    }
}
