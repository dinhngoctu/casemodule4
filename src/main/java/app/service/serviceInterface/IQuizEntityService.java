package app.service.serviceInterface;

import app.model.AnswerEntity;
import app.model.QuizEntity;

import java.util.List;

public interface IQuizEntityService {
    public Long getMaxId();

    public void add(QuizEntity quizEntity);

    public List<QuizEntity> findAll();

    public QuizEntity findOne(Long id);

    public void addAll(List<QuizEntity> quizEntities);
}
