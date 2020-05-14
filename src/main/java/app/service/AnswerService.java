package app.service;

import app.model.AnswerEntity;
import app.repository.AnswerRepoSql;
import app.repository.repoInterface.IAnswerRepo;
import app.service.serviceInterface.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnswerService implements IAnswerService {
    @Autowired
    AnswerRepoSql answerRepoSql;
    @Autowired
    IAnswerRepo answerRepo;

    public Long getMaxId() {
      Long id = answerRepoSql.getMaxId();
        return id;
    }

    @Override
    public void add(List<AnswerEntity> list) {
        answerRepo.saveAll(list);
    }

    @Override
    public AnswerEntity findOne(Long id) {
        return answerRepoSql.findOne(id);
    }

//    @Override
//    public List<AnswerEntity> findByQuizId(Long quizId) {
//        return answerRepoSql.findByQuizId(quizId);
//    }
}
