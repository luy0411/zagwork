package com.zagwork.test.user.microservice.service.test.util;

import com.zagwork.test.user.microservice.core.entity.UserORM;
import com.zagwork.test.user.microservice.core.domain.User;

public class UserUtil {

    public static final Long ID = 1L;
    public static final String NAME = "zagWorkTest";

    public static User getDefaultUser() {
        return new User(ID, NAME);
    }

    public static UserORM getDefaultUserORM() {
        return getUserORM(ID, NAME);
    }

    private static UserORM getUserORM(Long id, String name) {
        UserORM user = new UserORM();
        user.setId(id);
        user.setName(name);
        return user;
    }

}
