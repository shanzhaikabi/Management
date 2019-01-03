package com.ssh.respository;

import com.ssh.entity.Character;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class CharacterRepositoryImpl implements CharacterRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Character load(Long id) {
        return (Character) getCurrentSession().load(Character.class,id);
    }

    public Character get(Long id) {
        return (Character) getCurrentSession().get(Character.class,id);
    }

    public List<Character> findAll() {
        return null;
    }

    @Transactional
    public void persist(Character entity) {
        getCurrentSession().persist(entity);
    }

    @Transactional
    public Long save(Character entity) {
        return (Long)getCurrentSession().save(entity);
    }

    @Transactional
    public void saveOrUpdate(Character entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Transactional
    public void delete(Long id) {
        getCurrentSession().delete(id);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}
