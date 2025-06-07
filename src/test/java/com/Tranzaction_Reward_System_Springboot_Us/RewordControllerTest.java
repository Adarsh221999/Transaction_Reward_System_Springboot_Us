package com.Tranzaction_Reward_System_Springboot_Us;


import com.Tranzaction_Reward_System_Springboot_Us.Controller.RewordController;
import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl.RewordsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;




@Import(MockServiceConfig.class)
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
            request.setCustomerName("Adarsh");
            request.setCustomerId(123L);
            request.setTranzationAmount(100.00);


            Rewords response = new Rewords();
            response.setCustomerName("Adarsh");
            response.setCustomerId(123L);
            response.setTranzationAmount(100.00);
            response.setRewordPoints(50L);
            response.setTranzationId(8);
            response.setDate(LocalDate.of(2025,06,06));

            Mockito.when(rewordsService.addRewordPoints(Mockito.mock(Rewords.class))).thenReturn(response);


            mockMvc.perform(post("/rewords/addReword")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk());;
//                    .andExpect((ResultMatcher)jsonPath("$.customerId").value(123L))
//                   .andExpect((ResultMatcher)jsonPath("$.rewordPoints").value(50))
//                    .andExpect((ResultMatcher)jsonPath("$.tranzationAmount").value(100.00));
    }

}


