package com.zagwork.test.user.microservice.service.test.features;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zagwork.test.user.microservice.core.converter.UserConverter;
import com.zagwork.test.user.microservice.core.entity.UserORM;
import com.zagwork.test.user.microservice.core.repository.UserRepository;
import com.zagwork.test.user.microservice.service.main.ApplicationStarter;
import com.zagwork.test.user.microservice.service.test.checker.UserJsonChecker;
import com.zagwork.test.user.microservice.service.test.util.UserUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = {ApplicationStarter.class})
@RunWith(SpringRunner.class)
public class CreateUser {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserConverter converter;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createUser() throws Exception {
        UserORM defaultUser = UserUtil.getDefaultUserORM();

        MvcResult result = mockMvc.perform(post("/users/")
                .content(asJson(converter.toDomain(defaultUser)))
                .contentType(jsonContentType()))
                .andExpect(status().isOk()).andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        UserJsonChecker checker = new UserJsonChecker(contentAsString);
        checker.check(UserUtil.getDefaultUser());
    }

    private static MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    public static MediaType jsonContentType(){
        return contentType;
    }

    public static String asJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
