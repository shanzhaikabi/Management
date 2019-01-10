package com.ssh.respository;

import com.ssh.entity.Chara;
import com.ssh.entity.User;
import com.ssh.entity.UserCharacter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class UserCharacterRepositoryImpl implements UserCharacterRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public UserCharacter load(Integer id) {
        return (UserCharacter) getCurrentSession().load(UserCharacter.class,id);
    }

    @Override
    public UserCharacter get(Integer id) {
        return (UserCharacter) getCurrentSession().get(UserCharacter.class,id);
    }

    @Override
    public List<UserCharacter> findAll() {
        return null;
    }

    @Override
    public void persist(UserCharacter entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Integer save(UserCharacter entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(UserCharacter entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(UserCharacter entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public List<Chara> getCharacters(User user) {
        return (List<Chara>) getCurrentSession().createQuery("from Chara c,UserCharacter u where c.characterid = u.characterid and u.userid = ?").setParameter(0,user.getUserid())
                .list().stream().map(object -> ((Object[])object)[0]).collect(Collectors.toList());
    }

    @Override
    public List<Integer> getCharacterIds(User user) {
        return (List<Integer>) getCurrentSession().createCriteria(UserCharacter.class)
                .add(Restrictions.eq("userid",user.getUserid())).list().stream()
                .map(object -> ((UserCharacter)object).getCharacterid()).collect(Collectors.toList());
    }

    public UserCharacter get(String userId,Integer characterId){
        return (UserCharacter) getCurrentSession().createCriteria(UserCharacter.class)
                .add(Restrictions.eq("userid",userId))
                .add(Restrictions.eq("characterid",characterId)).uniqueResult();
    }

    @Override
    public void delete(String userId, Integer characterId) {
        delete(get(userId,characterId));
    }


}
