package app.repository;

import app.model.QuizEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class QuizRepoSQL{
    @PersistenceContext
    EntityManager em;

    public Long getMaxID() {
        String sqlquerry = "select max(id) from quiz;";
        Query query = em.createNativeQuery(sqlquerry);
        Object obj = query.getSingleResult();
        if (obj == null) {
            return 0l;
        }else{
            return Long.valueOf(obj.toString())+1;
        }
    }

    @Transactional
    public List<QuizEntity> findAll() {
        Query query = em.createQuery("select q from QuizEntity q", QuizEntity.class);
        try {
            List<QuizEntity> list = query.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public QuizEntity findOne(Long id) {
        TypedQuery<QuizEntity> query = em.createQuery("select c from QuizEntity c where c.id = : id",QuizEntity.class);
        query.setParameter("id", Long.valueOf(id));
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
