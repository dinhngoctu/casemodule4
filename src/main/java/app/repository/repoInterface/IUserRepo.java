package app.repository.repoInterface;

import app.model.UserEntity;

public interface IUserRepo extends IGeneralRepo<UserEntity>{
    UserEntity findByName(String name);
}
