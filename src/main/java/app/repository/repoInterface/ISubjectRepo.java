package app.repository.repoInterface;

import app.model.SubjectEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISubjectRepo extends PagingAndSortingRepository<SubjectEntity,Long> {
}
