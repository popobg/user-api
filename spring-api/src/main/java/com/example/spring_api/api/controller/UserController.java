package com.example.spring_api.api.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.spring_api.api.model.User;
import com.example.spring_api.service.UserService;

// authorize all browser pages to make request to this server
@CrossOrigin(origins="*")
@RestController
public class UserController {

    private UserService userService;

    // unnecessary but it is what is called by Spring Boot
    // to do dependency injection.
    // @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //RequestParam: decode the querry to find the parameter
    // example of request: ``
    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        Optional<User> user =  userService.getUser(id);

        if(user.isPresent()) {
            return (User) user.get();
        }

        // normally we return something like "content not found"
        return null;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
