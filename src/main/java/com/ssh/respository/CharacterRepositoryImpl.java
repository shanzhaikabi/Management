package com.ssh.respository;

import com.ssh.entity.Chara;
import com.ssh.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CharacterRepositoryImpl implements CharacterRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Chara load(Integer id) {
        return (Chara) getCurrentSession().load(Chara.class,id);
    }

    public Chara get(Integer id) {
        return (Chara) getCurrentSession().get(Chara.class,id);
    }

    public List<Chara> findAll() {
        return getCurrentSession().createCriteria(Chara.class).list();
    }

    public List<Operation> findAllOperation() {
        return getCurrentSession().createCriteria(Operation.class).list();
    }

    public void persist(Chara entity) {
        getCurrentSession().persist(entity);
    }

    public Integer save(Chara entity) {
        return (Integer)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Chara entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Chara entity) {
        getCurrentSession().delete(entity);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}
