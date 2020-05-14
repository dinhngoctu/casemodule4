package app.repository.repoInterface;

import app.model.QuizEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IQuizRepo extends PagingAndSortingRepository<QuizEntity,Long> {
}
