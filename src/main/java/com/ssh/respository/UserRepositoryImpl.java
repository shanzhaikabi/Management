package com.ssh.respository;

import com.ssh.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public User load(String id) {
        return (User)getCurrentSession().load(User.class,id);
    }

    public User get(String id) {
        return (User)getCurrentSession().get(User.class,id);
    }

    public boolean findList(String type,String con){
        Query query = getCurrentSession().createQuery("select " + type + " from User usr where " + type + " = '" + con + "'");
        List<User> stus = query.list();
        return stus.size() > 0;
    }

    public List<User> findAll() {
        return null;
    }

    public void persist(User entity) {
        getCurrentSession().persist(entity);
    }

    public String save(User entity) {
        Session s = getCurrentSession();
        Transaction tx = s.beginTransaction();
        String ret = (String)s.save(entity);
        tx.commit();
        s.close();
        return ret;
    }

    public void saveOrUpdate(User entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(String id) {
        User user = load(id);
        getCurrentSession().delete(user);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}
