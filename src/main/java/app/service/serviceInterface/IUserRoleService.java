package app.service.serviceInterface;

import app.model.UserRoleEntity;

import java.util.List;

public interface IUserRoleService {
    List<UserRoleEntity> findByUserName(String userName);

    void add(UserRoleEntity user);

    void edit(UserRoleEntity user);

    void remove(UserRoleEntity user);

    List<UserRoleEntity> findAll();
}
