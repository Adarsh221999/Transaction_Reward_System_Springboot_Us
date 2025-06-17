package com.Transaction_Reward_System_Springboot_Us;
import com.Transaction_Reward_System_Springboot_Us.Controller.RewardController;
import com.Transaction_Reward_System_Springboot_Us.Entity.Rewards;
import com.Transaction_Reward_System_Springboot_Us.Models.RewardSummeryByCustomer;
import com.Transaction_Reward_System_Springboot_Us.Service.RewardsServiceImpl;
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
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class RewordControllerTest {

    @Mock
    private RewardsServiceImpl RewardsService;

    //Injecting into the Conroller Layer All Other Mocks.
    @InjectMocks
    private RewardController rewardController;

    //Mock Mvc For Simulation of Http Calls Mocking
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Setup for the Mocking
    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(rewardController).build();
    }

     /*
    Test Method to get reword adding.
     */

    @Test
    void addRewordTest() throws Exception {
        Rewards request = new Rewards();
        request.setCustomerName("Adarsh");
        request.setTransactionAmount(100.00);

        Rewards response = new Rewards();
        response.setCustomerName("Adarsh");
        response.setTransactionAmount(100.00);
        response.setRewardPoints(50L);
        response.setTransactionId(8);
        response.setDate((LocalDate.of(2025,6,6)));

        Mockito.when(RewardsService.addRewardPoints(Mockito.any(Rewards.class))).thenReturn(response);

        mockMvc.perform(post("/reword/addReword")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value(123))
                .andExpect(jsonPath("$.rewordPoints").value(50))
                .andExpect(jsonPath("$.transactionAmount").value(100.00))
                .andExpect(jsonPath("$.transactionId").value(8));

    }

    /*
   Test Method to get reword summery for  monthly Summery for only one customer
    */
    @Test
    void getRewordMonthlyTest() throws Exception {
        RewardSummeryByCustomer request = new RewardSummeryByCustomer();

        Map<String , Integer> RewardsByMonth = new HashMap<>();
        RewardsByMonth.put("2025-07",850);
        RewardsByMonth.put("2025-06",19850);
        RewardsByMonth.put("2025-08",9850);

        request.setCustomerName("Adarsh");
        request.setCustomerId(10L);
        request.setTotalSumOfAllRewards(30550L);
        request.setRewordPoints(RewardsByMonth);

        RewardSummeryByCustomer response = new RewardSummeryByCustomer();
        response.setCustomerName("Adarsh");
        response.setCustomerId(10L);
        response.setTotalSumOfAllRewards(30550L);
        Map<String , Integer> RewardsByMonthResponce = new HashMap<>();
        RewardsByMonth.put("2025-07",850);
        RewardsByMonth.put("2025-06",19850);
        RewardsByMonth.put("2025-08",9850);
        response.setRewordPoints(RewardsByMonthResponce);

        Mockito.when(RewardsService.findRewardSummeryMonthlyByCustomerId(Mockito.anyLong(),Mockito.any(),Mockito.any())).thenReturn(response);

        mockMvc.perform(get("/reword/getRewardsByMonth/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("Adarsh"))
                .andExpect(jsonPath("$.customerId").value(10))
                .andExpect(jsonPath("$.rewordPoints").value(RewardsByMonthResponce))
                .andExpect(jsonPath("$.totalSumOfAllRewards").value(30550L));

    }
    /*
    Test Method to get reword summery for 3 months Summery
     */
    @Test
    void testGetThreeMonthsRewardsSummeryForAllCustomer() throws Exception {
        RewardSummeryByCustomer request = new RewardSummeryByCustomer();

        Map<String , Integer> RewardsByMonth = new HashMap<>();
        RewardsByMonth.put("2025-07",850);
        RewardsByMonth.put("2025-06",19850);
        RewardsByMonth.put("2025-08",9850);

        RewardSummeryByCustomer response = new RewardSummeryByCustomer();
        response.setCustomerName("Adarsh");
        response.setCustomerId(10L);
        response.setTotalSumOfAllRewards(30550L);
        Map<String , Integer> RewardsByMonthResponce = new HashMap<>();
        RewardsByMonth.put("2025-07",850);
        RewardsByMonth.put("2025-06",19850);
        RewardsByMonth.put("2025-08",9850);
        response.setRewordPoints(RewardsByMonthResponce);

        Mockito.when(RewardsService.getRewardsummeryForLastThreeMonth(Mockito.any(),Mockito.any())).thenReturn(List.of(response));

        mockMvc.perform(get("/reword/getThreeMonthsRewardsSummeryForAllCustomer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(response)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customerName").value("Adarsh"))
                .andExpect(jsonPath("$[0].customerId").value(10))
                .andExpect(jsonPath("$[0].rewordPoints").value(RewardsByMonthResponce))
                .andExpect(jsonPath("$[0].totalSumOfAllRewards").value(30550L));


    }


}