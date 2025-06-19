package com.TransactionReward;

import com.TransactionReward.Entity.Rewards;
import com.TransactionReward.Models.RewardSummeryByCustomer;
import com.TransactionReward.Repository.RewardsRepo;
import com.TransactionReward.Service.RewardsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RewardsServiceImplTest {

    @Mock
    private RewardsRepo RewardsRepository;

    @InjectMocks
    private RewardsServiceImpl RewardsService;

    //Setting Up the before setup.
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /*
    This method tests Save reword method of repository.
     */
    @Test
    @DisplayName("Save reword and verify it is persisted")
    void testaddRewordPoints(){

        // Request Setup
        Rewards request = new Rewards();
        request.setCustomerName("Adarsh");
        //request.setCustomerId(123L);
        request.setTransactionAmount(100.00);

        // Response Setup
        Rewards response = new Rewards();
        response.setCustomerName("Adarsh");
        //response.setCustomerId(123L);
        response.setTransactionAmount(100.00);
        response.setRewardPoints(50L);
        response.setTransactionId(8);
        response.setDate((LocalDate.of(2025,6,6)));

        // Writing dummy logic for the repository layer
        when(RewardsRepository.save(any(Rewards.class))).thenReturn(response);

        //Hitting repository layer for data retrieval.
        Rewards savedRewards = RewardsService.addRewardPoints(request);

        //Validations of Response.
        assertNotNull(savedRewards);
        assertThat(savedRewards.getCustomerName()).isEqualTo("Adarsh");
        assertThat(savedRewards.getTransactionAmount()).isEqualTo(100);
        assertThat(savedRewards.getRewardPoints()).isEqualTo(50L);
        assertThat(savedRewards.getTransactionId()).isEqualTo(8);
        assertThat(savedRewards.getDate()).isEqualTo((LocalDate.of(2025,6,6)));

    }
     /*
    This method tests the response summery for last 3 months for each customer.
     */
    @Test
    @DisplayName("Save reword Summery is obtained for over last 3 months")
    void testGetRewardsummeryForLastThreeMonth() {
        //Date for the range
        LocalDate endDate = LocalDate.now();
        //Date for the range
        LocalDate startDate = endDate.minusMonths(3);

        //List of All Rewards for last 3 months
        List<RewardSummeryByCustomer> all_Customer_Rewardsummery_LastThreeMonths = new ArrayList<>();

        //Map for Summery
        Map<String , Integer> RewardsummeryByMonth = new HashMap<>();
        RewardsummeryByMonth.put("2025-06", 100);

        //Response Setup
        Rewards rewordResponse1 = new Rewards();
        rewordResponse1.setCustomerName("Adarsh");
        rewordResponse1.setTransactionAmount(120.00);
        rewordResponse1.setRewardPoints(50L);
        rewordResponse1.setTransactionId(8);
        rewordResponse1.setDate((LocalDate.of(2025,6,6)));

        // Response2 Setup
        Rewards rewordResponse2 = new Rewards();
        rewordResponse2.setCustomerName("Suraj");
        rewordResponse2.setTransactionAmount(120.00);
        rewordResponse2.setRewardPoints(50L);
        rewordResponse2.setTransactionId(8);
        rewordResponse2.setDate((LocalDate.of(2025,6,6)));

        //List Of Rewards
        List<Rewards> RewardOfLastThreeMonths = List.of(rewordResponse1,rewordResponse2);

        RewardSummeryByCustomer response1 = new RewardSummeryByCustomer();
        response1.setCustomerName("Adarsh");
//        response1.setCustomerId(123L);
//        response1.setRewordPoints(RewardsummeryByMonth);
        response1.setTotalSumOfAllRewards(100L);

        RewardSummeryByCustomer response2 = new RewardSummeryByCustomer();
        response2.setCustomerName("Suraj");
//        response2.setCustomerId(125L);
//        response2.setRewordPoints(RewardsummeryByMonth);
        response2.setTotalSumOfAllRewards(100L);

        //Responce of Reword Summery By Last theree months endpoint.
       List<RewardSummeryByCustomer> RewardsummeryLastThreeMonthsMock = List.of(response1,response2);

       //List Of Rewards
       List<Rewards> rewardOfAllRewards = List.of(rewordResponse1,rewordResponse2);

       //Mocked Steps
       when(RewardsRepository.findByCustomerId(anyLong())).thenReturn(rewardOfAllRewards);

       when(RewardsRepository.findByDateBetween(startDate,endDate)).thenReturn(RewardOfLastThreeMonths);


        // Action On Service Layer
       RewardsummeryLastThreeMonthsMock=RewardsService.getRewardsummeryForLastThreeMonth(startDate,endDate);

       // Asserction
       assertNotNull(RewardsummeryLastThreeMonthsMock);
       assertThat(RewardsummeryLastThreeMonthsMock.getFirst().getCustomerName()).isEqualTo("Adarsh");
//       assertThat(RewardsummeryLastThreeMonthsMock.getFirst().getCustomerId()).isEqualTo(123L);
//       assertThat(RewardsummeryLastThreeMonthsMock.getFirst().getRewordPoints()).isEqualTo(RewardsummeryByMonth);
       assertThat(RewardsummeryLastThreeMonthsMock.getFirst().getTotalSumOfAllRewards()).isEqualTo(100);
    }

    @Test
    @DisplayName("Testing Monthly Summery Reword Points Endpoint")
    void testfindRewardsummeryMonthlyByCustomerId(){

        Long customerId = 123L;
        List<Rewards> allRewards  = new ArrayList<>();

        Map<String , Integer> RewardsummeryByMonth = new HashMap<>();
        RewardsummeryByMonth.put("2025-06", 50);

        // Response Setup
        Rewards response = new Rewards();
        response.setCustomerName("Adarsh");
        response.setTransactionAmount(100.00);
        response.setRewardPoints(50L);
        response.setTransactionId(8);
        response.setDate((LocalDate.of(2025,6,6)));

        RewardSummeryByCustomer Summeryresponse1 = new RewardSummeryByCustomer();
        Summeryresponse1.setCustomerName("Adarsh");
//        Summeryresponse1.setCustomerId(123L);
//        Summeryresponse1.setRewordPoints(RewardsummeryByMonth);
        Summeryresponse1.setTotalSumOfAllRewards(270L);

        // Adding reword to list
        allRewards.add(response);

        //Mocking the Flow of Repository.
        when(RewardsRepository.findByCustomerId(123L)).thenReturn(allRewards);

        //Hitting repository layer for data retrieval.
        RewardSummeryByCustomer savedRewards = RewardsService.findRewardSummeryMonthlyByCustomerId(customerId,LocalDate.now(),LocalDate.now().minusMonths(3));

        //Validations of Response.
        assertNotNull(savedRewards);
        assertThat(savedRewards.getCustomerName()).isEqualTo("Adarsh");
//        assertThat(savedRewards.getCustomerId()).isEqualTo(123L);
//        assertThat(savedRewards.getRewordPoints()).isEqualTo(RewardsummeryByMonth);

    }

    /*
    This method tests Save reword method of repository.
     */
    @Test
    @DisplayName("Unit Test for Getting Rewards By transactionId")
    void testgetRewordPoints(){

        // Response Setup
        Rewards response = new Rewards();
        response.setCustomerName("Adarsh");
        response.setTransactionAmount(100.00);
        response.setRewardPoints(50L);
        response.setTransactionId(8);
        response.setDate((LocalDate.of(2025,6,6)));

        // Writing Mock dummy logic for the repository layer
        Mockito.when(RewardsRepository.getById(Mockito.anyInt())).thenReturn(response);

        //Hitting repository layer for data retrieval.
        Rewards savedRewards = RewardsService.getRewardPoints(8);

        //Validations of Response.
        assertNotNull(savedRewards);
        assertThat(savedRewards.getCustomerName()).isEqualTo("Adarsh");
        assertThat(savedRewards.getTransactionAmount()).isEqualTo(100);
        assertThat(savedRewards.getRewardPoints()).isEqualTo(50L);
        assertThat(savedRewards.getTransactionId()).isEqualTo(8);
        assertThat(savedRewards.getDate()).isEqualTo((LocalDate.of(2025,6,6)));
    }

}
