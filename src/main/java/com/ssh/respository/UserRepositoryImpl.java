package com.ssh.respository;

import com.ssh.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public User load(String id) {
        return (User)getCurrentSession().load(User.class,id);
    }

    public User get(String id) {
        return (User)getCurrentSession().get(User.class,id);
    }

    public boolean findList(String type,String con){
        List<User> list = getCurrentSession().createCriteria(User.class).add(Restrictions.eq("type",con)).list();
        return list.size() > 0;
    }

    public List<User> findAll() {
        return null;
    }

    @Transactional
    public void persist(User entity) {
        getCurrentSession().persist(entity);
    }

    @Transactional
    public String save(User entity) {
        return (String) getCurrentSession().save(entity);
    }

    @Transactional
    public void saveOrUpdate(User entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Transactional
    public void delete(String id) {
        User user = load(id);
        getCurrentSession().delete(user);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}
