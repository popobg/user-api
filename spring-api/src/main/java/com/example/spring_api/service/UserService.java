package com.example.spring_api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.spring_api.api.model.User;

@Service
public class UserService {

    // usually, link to repository and database;
    // here, we are working with a list for simplify our test.
    private List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>(Arrays.asList(
            new User(1, "Bertrand", 32, "béber@mailcom"),
            new User(2, "Jeanne", 53, "jeanne@mail.com"),
            new User(3, "Popo", 26, "popo@mail.com"),
            new User(4, "Benoît", 19, "bebe@mail.com")
        ));

    }

    public Optional<User> getUser(Integer id) {
        // in case no user is find by this Id
        Optional<User> optional = Optional.empty();

        for (User user: userList) {
            if(id == user.getId()) {
                optional = Optional.of(user);
                break;
            }
        }

        return optional;
    }

    public List<User> getUsers() {
        return userList;
    }
}
