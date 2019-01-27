package com.zagwork.test.interest.microservice.service.controller;

import com.zagwork.test.interest.microservice.core.manager.InterestManager;
import com.zagwork.test.interest.microservice.core.domain.InterestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/interests")
public class InterestController {

    @Autowired
    InterestManager interestManager;

    @GetMapping
    public List<InterestData> getAll(){
        return interestManager.getAll();
    }

    @GetMapping(value = "/user/{userId}")
    public List<InterestData> getByUserId(@PathVariable("userId") Long userId){
        return interestManager.getAllByUserId(userId);
    }

    @PostMapping
    public InterestData create(@RequestBody InterestData interestData){
        return interestManager.create(interestData);
    }
}
