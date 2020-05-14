package app.service.serviceInterface;

import app.model.UserEntity;

import java.util.List;

public interface IUserService {
    UserEntity findByName(String name);

    void add(UserEntity user);

    void edit(UserEntity user);

    void remove(UserEntity user);

    List<UserEntity> findAll();
}
