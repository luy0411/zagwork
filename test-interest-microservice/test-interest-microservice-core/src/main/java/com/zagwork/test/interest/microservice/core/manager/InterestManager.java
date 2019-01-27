package com.zagwork.test.interest.microservice.core.manager;

import com.zagwork.test.interest.microservice.core.converter.InterestConverter;
import com.zagwork.test.interest.microservice.core.domain.InterestData;
import com.zagwork.test.interest.microservice.core.domain.UserData;
import com.zagwork.test.interest.microservice.core.repository.InterestRepository;
import com.zagwork.test.interest.microservice.core.entity.InterestORM;
import com.zagwork.test.interest.microservice.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterestManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterestManager.class);

    @Autowired
    private InterestRepository repository;

    @Autowired
    private InterestConverter converter;

    @Autowired
    private UserService userService;

    public List<InterestData> getAll() {
        List<InterestData> interests = new ArrayList<>();

        for (InterestORM interestORM : repository.findAll()) {
            interests.add(converter.toDomain((interestORM)));
        }

        return interests;
    }

    public List<InterestData> getAllByUserId(Long userId) {
        UserData userById = userService.getUserById(userId);
        List<InterestData> interests = new ArrayList<>();

        if (userById != null) {
            for (InterestORM interestORM : repository.findAllByUserId(userId)) {
                interests.add(converter.toDomain((interestORM)));
            }
        }

        return interests;
    }

    public InterestData create(InterestData interestData) {
        InterestORM interestORM = converter.toEntity(interestData);
        InterestORM saved = repository.save(interestORM);
        return converter.toDomain(saved);
    }


}
