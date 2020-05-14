package app.repository.repoInterface;

import app.model.AnswerEntity;
import org.springframework.data.repository.CrudRepository;

public interface IAnswerRepo extends CrudRepository<AnswerEntity,Long> {
}
