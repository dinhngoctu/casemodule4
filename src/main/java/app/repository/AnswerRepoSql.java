package app.repository;

import app.model.AnswerEntity;
import app.model.QuizEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class AnswerRepoSql {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public Long getMaxId() {
        String sqlQuerry = "select max(id) from answer;";
        Query query = em.createNativeQuery(sqlQuerry);
       Object obj= query.getSingleResult();
        if (obj == null) {
            return 0l;
        }else {
            return Long.valueOf(obj.toString())+1;
        }
    }
    public AnswerEntity findOne(Long id) {
        TypedQuery<AnswerEntity> query = em.createQuery("select c from AnswerEntity c where c.id = : id",AnswerEntity.class);
        query.setParameter("id", Long.valueOf(id));
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

//    public List<AnswerEntity> findByQuizId(Long id) {
//        TypedQuery<AnswerEntity> query = em.createQuery("select a from AnswerEntity a where a.quizByQuizId=:id", AnswerEntity.class);
//        return query.getResultList();
//    }
}
