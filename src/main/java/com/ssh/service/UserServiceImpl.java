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
        //System.out.println(user.getUserid());
        ModelMap map=new ModelMap();
        if (user.getUserid() == null){
            map.put("failReason","注册失败！用户名为空");
            return new ModelAndView("register",map);
        }
        if (user.getName() == null){
            map.put("failReason","注册失败！昵称为空");
            return new ModelAndView("register",map);
        }
        if (checkPassword(user.getPassword())){
            map.put("failReason","注册失败！密码不符合条件");
            return new ModelAndView("register",map);
        }
        String password = user.getPassword();
        user.setPassword(UserUtils.getSHA256StrJava(password));
        if (null != user.getEmail() && userRepository.findList("email",user.getEmail())){
            map.put("failReason","注册失败！邮箱已被注册");
            return new ModelAndView("register",map);
        }
        if (null != user.getTel() && userRepository.findList("tel",user.getTel())){
            map.put("failReason","注册失败！手机号已被注册");
            return new ModelAndView("register",map);
        }
        try {
            userRepository.save(user);
        }
        catch (HibernateException e){
            map.put("failReason","注册失败！用户名已存在");
            return new ModelAndView("registerFail",map);
        }
        map.put("user",user);
        return new ModelAndView("mainPage",map);
    }

    public ModelAndView login(User user){
        ModelMap map=new ModelMap();
        String loginFail = "登陆失败！用户名或密码不正确！";
        map.put("failReason",loginFail);
        if (user.getUserid() == null){
            return new ModelAndView("login",map);
        }
        String password = user.getPassword();
        user.setPassword(UserUtils.getSHA256StrJava(password));
        //System.out.println(password);
        User target = null;
        try {
            target = userRepository.get(user.getUserid());
            //System.out.println(target.getPassword());
            if (!target.getPassword().equals(user.getPassword())){
                return new ModelAndView("login",map);
            }
        }
        catch (HibernateException e){
            return new ModelAndView("login",map);
        }
        map.put("user",target);
        return new ModelAndView("mainPage",map);
    }

    public User getUserFromCookie(String userid) {
        return userRepository.get(userid);
    }
}
