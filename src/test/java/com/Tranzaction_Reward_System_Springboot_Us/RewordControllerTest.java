package com.Tranzaction_Reward_System_Springboot_Us;


import com.Tranzaction_Reward_System_Springboot_Us.Controller.RewordController;
import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl.RewordsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;





@WebMvcTest(RewordController.class)
public class RewordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RewordsServiceImpl rewordsService;

    @Autowired
    private ObjectMapper objectMapper;


        @Test
        void addRewordTest() throws Exception {
            Rewords request = new Rewords();
            request.setCustomerId(123L);
            request.setTranzationAmount(100.00);

            Rewords response = new Rewords();
            response.setCustomerId(123L);
            response.setTranzationAmount(100.00);

            Mockito.when(rewordsService.addRewordPoints(Mockito.any(Rewords.class))).thenReturn(response);


            mockMvc.perform(post("/addReword")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk())
                    .andExpect((ResultMatcher) jsonPath("$.customerId").value(123))
                    .andExpect((ResultMatcher) jsonPath("$.rewordPoints").value(50))
                    .andExpect((ResultMatcher) jsonPath("$.tranzationAmount").value(100));



    }

    @Configuration
    static class TestConfig {
        @Bean
        public RewordsServiceImpl rewordsService() {
            return Mockito.mock(RewordsServiceImpl.class);
        }
    }

}


