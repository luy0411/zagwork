package com.zagwork.test.api.manager;

import com.zagwork.test.api.domain.InputData;
import com.zagwork.test.api.domain.InterestData;
import com.zagwork.test.api.domain.UserData;
import com.zagwork.test.api.service.InterestService;
import com.zagwork.test.api.service.RiskService;
import com.zagwork.test.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainManager {

    @Autowired
    UserService userService;

    @Autowired
    RiskService riskService;

    @Autowired
    InterestService interestService;

    public List<InterestData> callServices(InputData data){
        UserData user = userService.getUser(data.getUsername());
        Float percent = riskService.getInterestPercentByRiskType(data.getRisk());
        InterestData interestData = getInputData(data, user, percent);

        interestService.create(interestData);

        return interestService.listByUser(user.getId());
    }

    private InterestData getInputData(InputData data, UserData user, Float percent) {
        InterestData interestData = new InterestData();
        interestData.setUserId(user.getId());
        interestData.setInterestPercent(percent);
        interestData.setLimit(data.getLimit().floatValue());
        interestData.setRiskType(data.getRisk());
        return interestData;
    }

}
