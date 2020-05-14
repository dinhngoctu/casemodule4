package app.repository.repoInterface;

import app.model.CorrectAnswerEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICorrectRepo extends CrudRepository<CorrectAnswerEntity, Long> {
}
