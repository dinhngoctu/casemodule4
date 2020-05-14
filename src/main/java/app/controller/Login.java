package app.controller;

import app.model.UserEntity;
import app.model.UserRoleEntity;
import app.service.serviceInterface.IUserRoleService;
import app.service.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Login {
    @Autowired
    IUserService userService;
    @Autowired
    IUserRoleService userRoleService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserEntity());
        return "login";
    }

    @PostMapping("/createuser")
    public ModelAndView getCreateUser(@Validated @ModelAttribute("user") UserEntity user, BindingResult bindingResult){
            if (!bindingResult.hasFieldErrors()) {
                UserEntity user1 = userService.findByName(user.getUserName());
                if (user1 != null) {
                    ModelAndView modelAndView = new ModelAndView("createuser");
                    modelAndView.addObject("message", "Tên này đã được sử dụng");
                    return modelAndView;
                }
                System.out.println(user.getPassword() +user.getUserName());
                userService.add(user);
                userRoleService.add(new UserRoleEntity(user.getUserName(),"ROLE_USER"));
                if (user.getUserName().equalsIgnoreCase("admin")) {userRoleService.add(new UserRoleEntity(user.getUserName(),"ROLE_ADMIN"));
                    userRoleService.add(new UserRoleEntity(user.getUserName(),"ROLE_USER"));
                }else{
                    userRoleService.add(new UserRoleEntity(user.getUserName(),"ROLE_USER"));
                }
                ModelAndView modelAndView = new ModelAndView("login");
                modelAndView.addObject("user", user);
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("createuser");
                return modelAndView;
            }
        }
    @GetMapping("/createuser")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new UserEntity());
        return "createuser";
    }
}
