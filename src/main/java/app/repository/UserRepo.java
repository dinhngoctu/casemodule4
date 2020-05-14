package app.repository;

import app.model.UserEntity;
import app.myutil.MyUtil;
import app.repository.repoInterface.IUserRepo;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


public class UserRepo implements IUserRepo {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserEntity> findAll() {
        TypedQuery<UserEntity> query = em.createQuery("select u from UserEntity u", UserEntity.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public UserEntity add(UserEntity user) {
       String pass = MyUtil.encrytePassword(user.getPassword());
       user.setPassword(pass);
        em.persist(user);
        return user;
    }

    @Transactional
    @Override
    public UserEntity edit(UserEntity user) {
        String pass = MyUtil.encrytePassword(user.getPassword());
        user.setPassword(pass);
        em.merge(user);
        return user;
    }
    @Transactional
    @Override
    public UserEntity remove(UserEntity user) {

        return user;
    }

    @Override
    public UserEntity findByName(String name) {
        System.out.println(name);
        TypedQuery<UserEntity> query = em.createQuery("select u from UserEntity u where u.userName = :name", UserEntity.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        }catch(NoResultException n) {
                return null;}
    }
}

