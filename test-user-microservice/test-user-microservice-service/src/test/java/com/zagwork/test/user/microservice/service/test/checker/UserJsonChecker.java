package com.zagwork.test.user.microservice.service.test.checker;

import com.zagwork.test.user.microservice.core.domain.User;
import org.json.JSONException;
import org.json.JSONObject;

import static org.assertj.core.api.Assertions.assertThat;

public class UserJsonChecker extends JsonChecker {

    public UserJsonChecker(String json) throws JSONException {
        super(new JSONObject(json));
    }

    @Override
    public void check(Object expected) throws JSONException {
        assertThat(actualJson.get("id")).isInstanceOfAny(Integer.class, Long.class);
        assertThat(actualJson.get("id")).isEqualTo(((User) expected).getId().intValue());
        assertThat(actualJson.get("name")).isEqualTo(((User) expected).getName());
    }

}
