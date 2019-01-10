package com.ssh.respository;

import com.ssh.entity.Character;
import com.ssh.entity.User;
import com.ssh.entity.UserCharacter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public UserCharacter load(Long id) {
        return null;
    }

    @Override
    public UserCharacter get(Long id) {
        return null;
    }

    @Override
    public List<UserCharacter> findAll() {
        return null;
    }

    @Override
    public void persist(UserCharacter entity) {

    }

    @Override
    public Long save(UserCharacter entity) {
        return null;
    }

    @Override
    public void saveOrUpdate(UserCharacter entity) {

    }

    @Override
    public void delete(UserCharacter entity) {

    }

    @Override
    public void flush() {

    }

    @Override
    public List<Character> getCharacters(User user) {
        return (List<Character>) getCurrentSession().createQuery("from Character c,UserCharacter u where c.userid = u.userid")
                .list().stream().map(object -> ((Object[])object)[0]).collect(Collectors.toList());
    }
}
