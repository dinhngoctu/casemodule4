package app.service;

import app.model.UserEntity;
import app.repository.repoInterface.IUserRepo;
import app.service.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements IUserService {
    @Autowired
    IUserRepo userRepo;

    @Override
    public UserEntity findByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public void add(UserEntity user) {
        userRepo.add(user);
    }

    @Override
    public void edit(UserEntity user) {

    }

    @Override
    public void remove(UserEntity user) {

    }

    @Override
    public List<UserEntity> findAll() {
        return userRepo.findAll();
    }
}
