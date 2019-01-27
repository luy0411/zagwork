package com.zagwork.test.user.microservice.core.manager;

import com.zagwork.test.user.microservice.core.converter.UserConverter;
import com.zagwork.test.user.microservice.core.entity.UserORM;
import com.zagwork.test.user.microservice.core.repository.UserRepository;
import com.zagwork.test.user.microservice.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManager.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter converter;

    public User getByName(String name) {
        LOGGER.info("Searching user by name " + name);
        List<UserORM> users = userRepository.findUserByName(name);
        if (!users.isEmpty()) {
            UserORM user = users.get(0);
            return converter.toDomain(user);
        }

        return null;
    }

    public User create(User user){
        LOGGER.info("Creating user by user " + user);
        UserORM userORM = converter.toEntity(user);
        UserORM saved = userRepository.save(userORM);
        return converter.toDomain(saved);
    }

    public User getById(Long userId) {
        LOGGER.info("Searching user by id " + userId);
        Optional<UserORM> userORM = userRepository.findById(userId);
        if (userORM.isPresent()){
            return converter.toDomain(userORM.get());
        }
        return null;
    }
}
