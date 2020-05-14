package app.service;


import app.model.QuizEntity;
import app.repository.QuizRepoSQL;
import app.repository.repoInterface.IQuizRepo;
import app.service.serviceInterface.IQuizEntityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class QuizEntityService implements IQuizEntityService {

    @Autowired
    QuizRepoSQL quizRepoSQL;
    @Autowired
    IQuizRepo quizRepo;

    @Override
    public Long getMaxId() {
        return quizRepoSQL.getMaxID();
    }

    @Override
    public void add(QuizEntity quizEntity) {
        quizRepo.save(quizEntity);
    }

    @Override
    public List<QuizEntity> findAll() {
        List<QuizEntity> list = quizRepoSQL.findAll();
            return list;
        }

    @Override
    public QuizEntity findOne(Long id) {
        System.out.println(id);
        Optional<QuizEntity> op = quizRepo.findById(id);
        System.out.println(op.get().getId());
        return op.get();
    }

    @Override
    public void addAll(List<QuizEntity> quizEntities) {
        quizRepo.saveAll(quizEntities);
    }
}
