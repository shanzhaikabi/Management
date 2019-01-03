package com.ssh.service;

import com.ssh.entity.User;
import com.ssh.respository.UserRepository;
import com.ssh.utils.OtherUtils;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public String register(User user) {
        List ret = new ArrayList<>();
        if (null != user.getEmail() && userRepository.findList("email",user.getEmail())){
            return "注册失败！邮箱已被注册";
        }
        if (null != user.getTel() && userRepository.findList("tel",user.getTel())){
            return "注册失败！手机号已被注册";
        }
        try {
            userRepository.save(user);
        }
        catch (HibernateException e){
            return "注册失败！用户名已存在";
        }
        ret.add(user);
        return "success";
    }

    public String login(User user){
        User target;
        try {
            target = userRepository.get(user.getUserid());
            if (null == target || !target.getPassword().equals(user.getPassword())){
                return "登陆失败！用户名或密码错误";
            }
        }
        catch (HibernateException e){
            return "登陆失败！用户名或密码错误";
        }
        OtherUtils.convertBean2Bean(target,user);
        return "success";
    }

    public String editUser(User user,User target){
        if (null != user.getEmail() && userRepository.findList("email",user.getEmail())){
            return "修改失败！邮箱已被注册";
        }
        if (null != user.getTel() && userRepository.findList("tel",user.getTel())){
            return "修改失败！手机号已被注册";
        }
        OtherUtils.convertBean2Bean(user,target);
        return "修改成功";
    }

    public User getUserById(String userid) {
        return userRepository.get(userid);
    }
}
