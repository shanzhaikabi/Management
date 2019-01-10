package com.ssh.respository;

import com.ssh.entity.Character;
import com.ssh.entity.User;
import org.hibernate.Query;

import java.util.List;

public interface UserRepository extends DomainRepository<User,String>{
    boolean findList(String type,String con);
}
