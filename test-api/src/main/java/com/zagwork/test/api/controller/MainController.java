package com.zagwork.test.api.controller;

import com.zagwork.test.api.domain.InputData;
import com.zagwork.test.api.domain.InterestData;
import com.zagwork.test.api.manager.MainManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("/api/main")
@RestController
public class MainController {

    @Autowired
    MainManager manager;

    @RequestMapping(value = "sendAll", method = RequestMethod.POST)
    public List<InterestData> sendAll(@RequestBody InputData data) {
        List<InterestData> interestData = manager.callServices(data);
        List<InterestData> sortedAndLimited = interestData.stream()
                .sorted(Comparator.comparingLong(InterestData::getId).reversed())
                .limit(5)
                .collect(Collectors.toList());
        return sortedAndLimited;
    }
}
