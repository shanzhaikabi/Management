package com.ssh.service;

import com.ssh.entity.User;
import com.ssh.respository.UserRepositoryImpl;
import com.ssh.utils.UserUtils;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepositoryImpl userRepository;

    private boolean checkPassword(String password){
        if (password.length() < 6 || password.length() > 24){
            return true;
        }
        return false;
    }

    public ModelAndView register(User user) {
        System.out.println(user.getUserid());
        ModelMap map=new ModelMap();
        if (user.getUserid() == null){
            map.put("failReason","用户名为空");
            return new ModelAndView("registerFail",map);
        }
        if (user.getName() == null){
            map.put("failReason","昵称为空");
            return new ModelAndView("registerFail",map);
        }
        if (checkPassword(user.getPassword())){
            map.put("failReason","密码不符合条件");
            return new ModelAndView("registerFail",map);
        }
        String password = user.getPassword();
        user.setPassword(UserUtils.getSHA256StrJava(password));
        if (null != user.getEmail() && userRepository.findList("email",user.getEmail())){
            map.put("failReason","邮箱已被注册");
            return new ModelAndView("registerFail",map);
        }
        if (null != user.getTel() && userRepository.findList("tel",user.getTel())){
            map.put("failReason","手机号已被注册");
            return new ModelAndView("registerFail",map);
        }
        try {
            userRepository.save(user);
        }
        catch (HibernateException e){
            map.put("failReason","用户名已存在");
            return new ModelAndView("registerFail",map);
        }
        map.put("user",user);
        return new ModelAndView("mainPage",map);
    }
}
