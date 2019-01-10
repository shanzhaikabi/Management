package com.ssh.respository;

import com.ssh.entity.Chara;
import com.ssh.entity.Operation;

import java.util.List;

public interface CharacterRepository extends DomainRepository<Chara,Integer>{
    List<Operation> findAllOperation();
}
