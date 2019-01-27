package com.zagwork.test.interest.microservice.core.service;

import com.zagwork.test.interest.microservice.core.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Value("${test.user.microservice.url}")
    String baseUrl;

    public UserData getUserById(Long userId){
        UserData user = new RestTemplate().getForObject(String.format(baseUrl, userId), UserData.class);
        return user;
    }

}
