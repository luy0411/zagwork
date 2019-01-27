package com.zagwork.test.risk.microservice.service.test.features;

import com.zagwork.test.risk.microservice.service.main.ApplicationStarter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = {ApplicationStarter.class})
@RunWith(SpringRunner.class)
public class GetRiskPercentage {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRiskPercentage() throws Exception {
        String type = "C";

        MvcResult result = mockMvc.perform(get("/risks?type=" + type))
                                  .andExpect(status().isOk()).andReturn();

        Float percentage = Float.valueOf(result.getResponse().getContentAsString());
        Assert.assertTrue(percentage == 0.2f);
    }

    @Test
    public void getRiskPercentageWithInvalidPath() throws Exception {
        mockMvc.perform(get("/risks/abc"))
               .andExpect(status().is4xxClientError());
    }

    @Test
    public void getRiskPercentageWithInvalidArg() throws Exception {
        mockMvc.perform(get("/risks?teste=123"))
                .andExpect(status().is5xxServerError());
    }
}
