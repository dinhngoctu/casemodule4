package app.repository.repoInterface;

import app.model.UserRoleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IUserRoleRepo extends PagingAndSortingRepository<UserRoleEntity,Long> {
    Iterable<UserRoleEntity> findAllByUserName(String userName);
}
