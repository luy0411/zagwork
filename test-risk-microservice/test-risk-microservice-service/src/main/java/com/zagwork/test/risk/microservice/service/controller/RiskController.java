package com.zagwork.test.risk.microservice.service.controller;

import com.zagwork.test.risk.microservice.core.manager.RiskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/risks")
public class RiskController {

    @Autowired
    RiskManager riskManager;

    @GetMapping
    public Float getInterestByRiskType(@RequestParam("type") String type){
        return riskManager.getInterestByRiskType(type);
    }

}
