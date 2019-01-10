package com.ssh.respository;

import com.ssh.entity.Character;
import com.ssh.entity.CharacterFunctionOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CharacterFunctionOperationRepositoryImpl implements CharacterFunctionOperationRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public CharacterFunctionOperation load(Long id) {
        return (CharacterFunctionOperation) getCurrentSession().load(CharacterFunctionOperation.class,id);
    }

    @Override
    public CharacterFunctionOperation get(Long id) {
        return (CharacterFunctionOperation) getCurrentSession().get(CharacterFunctionOperation.class,id);
    }

    @Override
    public List<CharacterFunctionOperation> findAll() {
        return null;
    }

    @Override
    public void persist(CharacterFunctionOperation entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Long save(CharacterFunctionOperation entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(CharacterFunctionOperation entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(CharacterFunctionOperation entity) {
        getCurrentSession().delete(entity);
    }

    public void delete(Long id) {
        getCurrentSession().delete(get(id));
    }

    @Override
    public void flush() {

    }

    @Override
    public List<Long> getOperationByCharacter(Character character) {
        return (List<Long>) getCurrentSession().createQuery("where c.characterid = ?")
                .setParameter(0,character.getCharacterid()).list().stream()
                .map(object -> ((Object[])object)[0]).collect(Collectors.toList());
    }

    @Override
    public void saveOperationForCharacter(Character character, String[] operations) {
        List<Long> operations_old = getOperationByCharacter(character);
        List<Long> operations_new = Arrays.stream(operations).map(object -> Long.valueOf(object)).collect(Collectors.toList());
        operations_new.removeIf(operation -> operations_old.contains(operation));
        operations_old.forEach(operation -> delete(operation));
        operations_new.forEach(id -> {
            CharacterFunctionOperation tmp = new CharacterFunctionOperation();
            tmp.setCharacterid(character.getCharacterid());
            tmp.setOperationid(id.intValue());
            save(tmp);
        });
    }

    @Override
    public boolean notHaveOperation(Character character, Long operationId) {
        return getCurrentSession().createCriteria(CharacterFunctionOperation.class)
                .add(Restrictions.eq("characterid",character.getCharacterid()))
                .add(Restrictions.eq("operationid",operationId)).list().isEmpty();
    }

}
