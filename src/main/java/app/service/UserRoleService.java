package app.service;

import app.model.UserRoleEntity;
import app.repository.repoInterface.IUserRoleRepo;
import app.service.serviceInterface.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class UserRoleService implements IUserRoleService {
    @Autowired
    IUserRoleRepo userRoleRepo;

    @Override
    public List<UserRoleEntity> findByUserName(String userName) {
        try {
            List<UserRoleEntity> listRoles = (List<UserRoleEntity>) userRoleRepo.findAllByUserName(userName);
            return listRoles;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public void add(UserRoleEntity userRole) {
        userRoleRepo.save(userRole);
    }

    @Override
    public void edit(UserRoleEntity user) {
        userRoleRepo.save(user);
    }

    @Override
    public void remove(UserRoleEntity userRole) {
        userRoleRepo.delete(userRole);
    }

    @Override
    public List<UserRoleEntity> findAll() {
        List<UserRoleEntity> list = (List<UserRoleEntity>)userRoleRepo.findAll();
        return list;
    }
}
