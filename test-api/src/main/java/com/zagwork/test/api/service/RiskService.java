package com.zagwork.test.api.service;

import com.zagwork.test.api.exception.MicroserviceIntegrationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiskService {

    @Value("${test.risk.microservice.base.url}")
    String baseUrl;

    public Float getInterestPercentByRiskType(String type){
        try {
            Float percent = new RestTemplate().getForObject(String.format(baseUrl, type), Float.class);
            return percent;
        } catch (Throwable e){
            throw new MicroserviceIntegrationException(e);
        }
    }

}
