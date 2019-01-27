package com.zagwork.test.user.microservice.core.converter;

import com.zagwork.test.user.microservice.core.domain.User;
import com.zagwork.test.user.microservice.core.entity.UserORM;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User toDomain(UserORM userORM) {
        return new User(userORM.getId(), userORM.getName());
    }

    public UserORM toEntity(User user) {
        return new UserORM(user.getName());
    }

}
