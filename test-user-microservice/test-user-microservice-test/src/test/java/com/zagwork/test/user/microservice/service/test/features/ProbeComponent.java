package com.zagwork.test.user.microservice.service.test.features;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
public class ProbeComponent {

    private static final String PROBE_URL = "http://localhost:8082/actuator/health";

    @Test
    public void probe(){
        HttpStatus statusCode = new RestTemplate().getForEntity(PROBE_URL, String.class).getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.OK);
    }
}
