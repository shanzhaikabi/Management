package com.ssh.respository;

import com.ssh.entity.CharacterFunctionOperation;
import com.ssh.entity.Character;

import java.util.List;

public interface CharacterFunctionOperationRepository extends DomainRepository<CharacterFunctionOperation,Long> {
    List<Long> getOperationByCharacter(Character character);
    void saveOperationForCharacter(Character character,String[] operations);
    boolean notHaveOperation(Character character,Long operationId);
}

