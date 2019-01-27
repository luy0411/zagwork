package com.zagwork.test.api.service;

import com.zagwork.test.api.domain.UserData;
import com.zagwork.test.api.exception.MicroserviceIntegrationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Value("${test.user.microservice.base.url}")
    String baseUrl;

    @Value("${test.user.microservice.search.url}")
    String searchUrl;

    public UserData getUser(String name){
        try {
            UserData user = new RestTemplate().getForObject(String.format(searchUrl, name), UserData.class);

            if (user == null) return createUser(name);

            return user;
        } catch (Throwable e){
            throw new MicroserviceIntegrationException(e);
        }
    }

    private UserData createUser(String name){
        try {
            RestTemplate restTemplate = new RestTemplate();
            UserData input = new UserData(name);
            UserData userData = restTemplate.exchange(baseUrl, HttpMethod.POST,
                    new HttpEntity<>(input, new HttpHeaders()),
                    new ParameterizedTypeReference<UserData>() {
                    }).getBody();
            return userData;
        } catch (Throwable e){
            throw new MicroserviceIntegrationException(e);
        }
    }
}
