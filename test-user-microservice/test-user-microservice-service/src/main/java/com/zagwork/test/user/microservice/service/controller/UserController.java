package com.zagwork.test.user.microservice.service.controller;

import com.zagwork.test.user.microservice.core.manager.UserManager;
import com.zagwork.test.user.microservice.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserManager userManager;

    @RequestMapping("/{userId}")
    public User getById(@PathVariable("userId") Long userId){
        return userManager.getById(userId);
    }

    @RequestMapping("/name/{name}")
    public User getByName(@PathVariable("name") String name){
        return userManager.getByName(name);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userManager.create(user);
    }

}
