package ru.SpringControlWork.SpringControlWork.controllers;

import ru.SpringControlWork.SpringControlWork.model.User;
import ru.SpringControlWork.SpringControlWork.service.FileGateway;
import ru.SpringControlWork.SpringControlWork.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final FileGateway fileGateway;

    public UserController(UserService userService, FileGateway fileGateway) {
        this.userService = userService;
        this.fileGateway = fileGateway;
    }
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        fileGateway.writeToFile(user.getId() + ".txt", user.getFirstName() + "\t" + user.getLastName());
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    String deleteUser(@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("/user-update/{id}")
    String getOne(@PathVariable("id") int id, Model model){
        User user = userService.getOne(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}