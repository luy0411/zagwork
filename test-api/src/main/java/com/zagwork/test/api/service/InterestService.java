package com.zagwork.test.api.service;

import com.zagwork.test.api.domain.InterestData;
import com.zagwork.test.api.exception.MicroserviceIntegrationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterestService {

    @Value("${test.interest.microservice.base.url}")
    String baseUrl;

    @Value("${test.interest.microservice.search.url}")
    String searchUrl;

    public List<InterestData> listByUser(Long userId){
        List<InterestData> interestData = new ArrayList<>();
        try {
            RestTemplate restTemplate = new RestTemplate();
            interestData = restTemplate.exchange(String.format(searchUrl, userId), HttpMethod.GET,
                    new HttpEntity<>(new HttpHeaders()),
                    new ParameterizedTypeReference<List<InterestData>>(){}).getBody();
        } catch (Throwable e){
            throw new MicroserviceIntegrationException(e);
        }

        return interestData;
    }

    public InterestData create(InterestData data){
        try {
            RestTemplate restTemplate = new RestTemplate();
            InterestData interestData = restTemplate.exchange(baseUrl, HttpMethod.POST,
                    new HttpEntity<>(data, new HttpHeaders()),
                    new ParameterizedTypeReference<InterestData>() {
                    }).getBody();
            return interestData;
        } catch (Throwable e) {
            throw new MicroserviceIntegrationException(e);
        }
    }

}
