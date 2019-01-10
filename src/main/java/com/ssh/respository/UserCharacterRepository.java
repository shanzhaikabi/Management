package com.ssh.respository;

import com.ssh.entity.Chara;
import com.ssh.entity.User;
import com.ssh.entity.UserCharacter;

import java.util.List;

public interface UserCharacterRepository extends DomainRepository<UserCharacter,Integer>{
    List<Chara> getCharacters(User user);
    List<Integer> getCharacterIds(User user);
    void delete(String user,Integer characterId);
}
