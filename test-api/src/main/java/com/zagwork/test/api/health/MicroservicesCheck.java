package com.zagwork.test.api.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MicroservicesCheck extends AbstractHealthIndicator {

    @Value("${test.user.microservice.health.url}")
    String userHealthURL;

    @Value("${test.user.microservice.health.url}")
    String riskHealthURL;

    @Value("${test.user.microservice.health.url}")
    String interestHealthURL;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean isUserMicroserviceUp = new RestTemplate().getForEntity(userHealthURL, String.class).getStatusCode().equals(HttpStatus.OK);
        boolean isRiskMicroserviceUp = new RestTemplate().getForEntity(riskHealthURL, String.class).getStatusCode().equals(HttpStatus.OK);
        boolean isInterestMicroserviceUp = new RestTemplate().getForEntity(interestHealthURL, String.class).getStatusCode().equals(HttpStatus.OK);

        String status = String.format("isUserMicroserviceUp: %b | isRiskMicroserviceUp: %b | isInterestMicroserviceUp: %b", isUserMicroserviceUp, isRiskMicroserviceUp, isInterestMicroserviceUp);

        if (isUserMicroserviceUp && isRiskMicroserviceUp && isInterestMicroserviceUp){
            builder.up().withDetail(status, HttpStatus.OK).build();
        } else {
            builder.down().withDetail(status, HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }
}
