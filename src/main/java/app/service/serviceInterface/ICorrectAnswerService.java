package app.service.serviceInterface;

import app.model.CorrectAnswerEntity;

import java.util.List;

public interface ICorrectAnswerService {
    public void add(List<CorrectAnswerEntity> list);

    public List<String> findAll();
}
