package com.zagwork.test.user.microservice.service.test.features;

import com.zagwork.test.user.microservice.core.entity.UserORM;
import com.zagwork.test.user.microservice.core.repository.UserRepository;
import com.zagwork.test.user.microservice.service.main.ApplicationStarter;
import com.zagwork.test.user.microservice.service.test.checker.UserJsonChecker;
import com.zagwork.test.user.microservice.service.test.util.UserUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = {ApplicationStarter.class})
@RunWith(SpringRunner.class)
public class GetUser {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository repository;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUser() throws Exception {
        UserORM defaultUser = UserUtil.getDefaultUserORM();

        Mockito.when(repository.findById(Mockito.any())).thenReturn(java.util.Optional.ofNullable(defaultUser));

        MvcResult result = mockMvc.perform(get("/users/" + defaultUser.getId()))
                                  .andExpect(status().isOk()).andReturn();

        UserJsonChecker checker = new UserJsonChecker((result.getResponse().getContentAsString()));
        checker.check(UserUtil.getDefaultUser());
    }

    @Test
    public void getUserWithInvalidPath() throws Exception {
        mockMvc.perform(get("/users/abc"))
               .andExpect(status().is4xxClientError());
    }

    @Test
    public void getUserWithInvalidArg() throws Exception {
        mockMvc.perform(get("/users?teste=123"))
                .andExpect(status().is4xxClientError());
    }
}
