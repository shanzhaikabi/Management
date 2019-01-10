package com.ssh.respository;

import com.ssh.entity.Chara;
import com.ssh.entity.CharacterFunctionOperation;
import com.ssh.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public CharacterFunctionOperation load(Integer id) {
        return (CharacterFunctionOperation) getCurrentSession().load(CharacterFunctionOperation.class,id);
    }

    @Override
    public CharacterFunctionOperation get(Integer id) {
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
    public Integer save(CharacterFunctionOperation entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(CharacterFunctionOperation entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(CharacterFunctionOperation entity) {
        getCurrentSession().delete(entity);
    }

    public void delete(Integer id) {
        getCurrentSession().delete(get(id));
    }

    @Override
    public void flush() {

    }

    @Override
    public List<Integer> getOperationIdByCharacter(Chara character) {
        return (List<Integer>) getCurrentSession().createCriteria(CharacterFunctionOperation.class)
                .add(Restrictions.eq("characterid",character.getCharacterid())).list()
                .stream().map(object -> ((CharacterFunctionOperation)object).getOperationid())
                .collect(Collectors.toList());
    }

    @Override
    public List<Operation> getOperationByCharacter(Chara character) {
        return (List<Operation>) getCurrentSession().createQuery("from Operation o,CharacterFunctionOperation c where c.characterid = ? and c.operationid = o.operationid")
                .setParameter(0,character.getCharacterid()).list().stream()
                .map(object -> ((Object[])object)[0]).collect(Collectors.toList());
    }

    @Override
    public void saveOperationForCharacter(Chara character, String[] operations) {
        List<Integer> operations_old = getOperationIdByCharacter(character);
        List<Integer> operations_new = new ArrayList<>();
        for (String operation : operations) {
            operations_new.add(Integer.valueOf(operation));
        }
        for (int i = 0;i < operations_new.size();i++) {
            Integer integer = operations_new.get(i);
            if (operations_old.contains(integer)) {
                operations_old.remove(integer);
                operations_new.remove(integer);
            }
        }
        operations_old.forEach(operation -> {
            if (operations != null) delete(operation);
        });
        operations_new.forEach(id -> {
            if (id != null){
                CharacterFunctionOperation tmp = new CharacterFunctionOperation();
                tmp.setCharacterid(character.getCharacterid());
                tmp.setOperationid(id);
                save(tmp);
            }
        });
    }

    @Override
    public boolean notHaveOperation(Chara character, Integer operationId) {
        return getCurrentSession().createCriteria(CharacterFunctionOperation.class)
                .add(Restrictions.eq("characterid",character.getCharacterid()))
                .add(Restrictions.eq("operationid",operationId)).list().isEmpty();
    }

}
