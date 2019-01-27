package com.zagwork.test.risk.microservice.core.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RiskManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(RiskManager.class);

    public Float getInterestByRiskType(String type) {

        Float percentage = 0.0f;

        if ("B".equals(type)) {
            percentage = 0.1f;
        } else if ("C".equals(type)){
            percentage = 0.2f;
        }

        LOGGER.info("Interest percentage for risk type " + type + " = " + percentage);

        return percentage;
    }



}
