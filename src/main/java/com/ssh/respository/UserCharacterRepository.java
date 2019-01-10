package com.ssh.respository;

import com.ssh.entity.Character;
import com.ssh.entity.User;
import com.ssh.entity.UserCharacter;

import java.util.List;

public interface UserCharacterRepository extends DomainRepository<UserCharacter,Long>{
    List<Character> getCharacters(User user);
}
