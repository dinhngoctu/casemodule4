package app.service.serviceInterface;

import app.model.AnswerEntity;

import java.util.List;

public interface IAnswerService {
    public Long getMaxId();

    public void add(List<AnswerEntity> list);

    public AnswerEntity findOne(Long id);

//    public List<AnswerEntity> findByQuizId(Long quizId);
}
