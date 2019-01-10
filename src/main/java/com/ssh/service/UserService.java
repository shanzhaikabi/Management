package com.ssh.service;

import com.ssh.entity.Chara;
import com.ssh.entity.Operation;
import com.ssh.entity.User;
import com.ssh.entity.UserCharacter;
import com.ssh.respository.CharacterFunctionOperationRepository;
import com.ssh.respository.UserCharacterRepository;
import com.ssh.respository.UserRepository;
import com.ssh.utils.OtherUtils;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCharacterRepository userCharacterRepository;
    @Autowired
    private CharacterFunctionOperationRepository cfoRepository;

    public String register(User user) {
        List ret = new ArrayList<>();
        if (null != user.getEmail() && user.getEmail().length() > 0 && userRepository.findList("email",user.getEmail())){
            return "注册失败！邮箱已被注册";
        }
        if (null != user.getTel() && user.getTel().length() > 0 && userRepository.findList("tel",user.getTel())){
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

    public String editUser(User user){
        if (null != user.getEmail() && !user.getEmail().equals("null") && userRepository.findList("email",user.getEmail())){
            return "修改失败！邮箱已被注册";
        }
        if (null != user.getTel()  && !user.getTel().equals("null") && userRepository.findList("tel",user.getTel())){
            return "修改失败！手机号已被注册";
        }
        userRepository.saveOrUpdate(user);
        return "修改成功";
    }

    public User getUserById(String userid) {
        return userRepository.get(userid);
    }

    /**
     *
     * @param user
     * @param operationId
     * @return 用户是否没有权限
     */
    public boolean notHaveOperation(User user,int operationId){
        List<Chara> list = userCharacterRepository.getCharacters(user);
        for (Chara character : list) {
            if (!cfoRepository.notHaveOperation(character,operationId)) return false;
        }
        return true;
    }

    public List<Object[]> showUsers(){
        List<User> list = userRepository.findAll();
        List<Object[]> finalList = list.stream().map(user -> {
            List<Chara> characters = userCharacterRepository.getCharacters(user);
            Object[] objects = new Object[]{user,characters};
            return objects;
        }).collect(Collectors.toList());
        return finalList;
    }

    public void editUserChar(User user,List<Integer> newList){
        List<Integer> oldList = userCharacterRepository.getCharacterIds(user);
        for (int i = 0;i < newList.size();i++) {
            Integer charId = newList.get(i);
            if (oldList.contains(charId)){
                System.out.println("We have this shit tooooooooo!" + charId);
                oldList.remove(charId);
                newList.remove(charId);
            }
        }
        oldList.forEach(chara -> {
            if (chara != null){
                System.out.println("I'll delete that shit!" + chara);
                userCharacterRepository.delete(user.getUserid(),chara);
            }
        });
        newList.forEach(chara -> {
            if (chara != null){
                System.out.println("Im saving that shit!" + chara);
                UserCharacter userCharacter = new UserCharacter();
                userCharacter.setUserid(user.getUserid());
                userCharacter.setCharacterid(chara);
                userCharacterRepository.save(userCharacter);
                System.out.println("saving !!! SAVING!");
            }
        });
    }

    public List<Chara> getCharactersByUser(User user){
        return userCharacterRepository.getCharacters(user);
    }

    public void saveOrUpdate(User user){
        userRepository.saveOrUpdate(user);
    }
}
