package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello Springboot";
    }

    @GetMapping(value = "getUserName")
    public String getUsername(String callback) {
        return "admin";
    }

//    @GetMapping("/user/{id}")
//    public User getUser(@PathVariable("id") Integer id) {
//        User user = userRepository.findOne(id);
//        return user;
//    }

    @GetMapping("/insert")
    public User insertUser(User user) {
        User user1 = userRepository.save(user);
        return user1;
    }


}
