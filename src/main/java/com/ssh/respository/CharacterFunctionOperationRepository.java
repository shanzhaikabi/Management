package com.ssh.respository;

import com.ssh.entity.CharacterFunctionOperation;
import com.ssh.entity.Chara;
import com.ssh.entity.Operation;

import java.util.List;

public interface CharacterFunctionOperationRepository extends DomainRepository<CharacterFunctionOperation,Integer> {
    List<Integer> getOperationIdByCharacter(Chara character);
    List<Operation> getOperationByCharacter(Chara character);
    void saveOperationForCharacter(Chara character, String[] operations);
    boolean notHaveOperation(Chara character, Integer operationId);
}

