package app.service;

import app.model.UserEntity;
import app.model.UserRoleEntity;
import app.repository.repoInterface.IUserRepo;
import app.service.serviceInterface.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceIml implements UserDetailsService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    IUserRoleService userRolesService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByName(userName);
        if (user == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        List<UserRoleEntity> listRole = userRolesService.findByUserName(user.getUserName());
        System.out.println(listRole.toString());
        for (UserRoleEntity userrole: listRole) {
            grantList.add(new SimpleGrantedAuthority(userrole.getRoleName()));
        }
        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(userName,user.getPassword(), grantList);
        System.out.println(user1.getAuthorities().toString());
        System.out.println(user1.getPassword());
        return user1;

    }
}
