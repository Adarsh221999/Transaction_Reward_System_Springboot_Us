package com.Transaction_Reward_System_Springboot_Us;
import com.Transaction_Reward_System_Springboot_Us.Controller.RewordController;
import com.Transaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Transaction_Reward_System_Springboot_Us.Models.RewordSummeryByCustomer;
import com.Transaction_Reward_System_Springboot_Us.RewordService.RewordsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class RewordControllerTest {

    @Mock
    private RewordsServiceImpl rewordsService;

    @InjectMocks
    private RewordController rewordController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(rewordController).build();
    }

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
        response.setDate((LocalDate.of(2025,6,6)));

        Mockito.when(rewordsService.addRewordPoints(Mockito.any(Rewords.class))).thenReturn(response);

        mockMvc.perform(post("/reword/addReword")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value(123))
                .andExpect(jsonPath("$.rewordPoints").value(50))
                .andExpect(jsonPath("$.tranzationAmount").value(100.00))
                .andExpect(jsonPath("$.tranzationId").value(8));
              //.andExpect(jsonPath("$.date").value(LocalDate.of(2025,6,6)));

    }


    @Test
    void getRewordMonthlyTest() throws Exception {
        RewordSummeryByCustomer request = new RewordSummeryByCustomer();

        Map<String , Integer> rewordsByMonth = new HashMap<>();
        rewordsByMonth.put("2025-07",850);
        rewordsByMonth.put("2025-06",19850);
        rewordsByMonth.put("2025-08",9850);

        request.setCustomerName("Adarsh");
        request.setCustomerId(10L);
        request.setTotalSumOfAllRewards(30550L);
        request.setRewordPoints(rewordsByMonth);

        RewordSummeryByCustomer response = new RewordSummeryByCustomer();
        response.setCustomerName("Adarsh");
        response.setCustomerId(10L);
        response.setTotalSumOfAllRewards(30550L);
        Map<String , Integer> rewordsByMonthResponce = new HashMap<>();
        rewordsByMonth.put("2025-07",850);
        rewordsByMonth.put("2025-06",19850);
        rewordsByMonth.put("2025-08",9850);
        response.setRewordPoints(rewordsByMonthResponce);

        Mockito.when(rewordsService.findRewordSummeryMonthlyByCustomerId(Mockito.anyLong())).thenReturn(response);

        mockMvc.perform(get("/reword/getRewordsByMonth/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("Adarsh"))
                .andExpect(jsonPath("$.customerId").value(10))
                .andExpect(jsonPath("$.rewordPoints").value(rewordsByMonthResponce))
                .andExpect(jsonPath("$.totalSumOfAllRewards").value(30550L));


    }

}