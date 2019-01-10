package com.ssh.respository;

import com.ssh.entity.User;

public interface UserRepository extends DomainRepository<User,String>{
    boolean findList(String type,String con);
}
