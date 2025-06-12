package com.Transaction_Reward_System_Springboot_Us;

import com.Transaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Transaction_Reward_System_Springboot_Us.Models.RewordSummeryByCustomer;
import com.Transaction_Reward_System_Springboot_Us.Repository.RewordsRepo;
import com.Transaction_Reward_System_Springboot_Us.Service.RewordsServiceImpl;
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
public class RewordsServiceImplTest {

    // Autowiring the repository object for testing .
    @Mock
    private RewordsRepo rewordsRepository;

    // Injected mocks into the service layer .
    //@Spy
    @InjectMocks
    private RewordsServiceImpl rewordsService;



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
        Rewords request = new Rewords();
        request.setCustomerName("Adarsh");
        request.setCustomerId(123L);
        request.setTransactionAmount(100.00);

        // Response Setup
        Rewords response = new Rewords();
        response.setCustomerName("Adarsh");
        response.setCustomerId(123L);
        response.setTransactionAmount(100.00);
        response.setRewordPoints(50L);
        response.setTransactionId(8);
        response.setDate((LocalDate.of(2025,6,6)));

        // Writing dummy logic for the repository layer
        when(rewordsRepository.save(any(Rewords.class))).thenReturn(response);

        //Hitting repository layer for data retrieval.
        Rewords savedRewords = rewordsService.addRewordPoints(request);

        //Validations of Response.
        assertNotNull(savedRewords);
        assertThat(savedRewords.getCustomerName()).isEqualTo("Adarsh");
        assertThat(savedRewords.getCustomerId()).isEqualTo(123L);
        assertThat(savedRewords.getTransactionAmount()).isEqualTo(100);
        assertThat(savedRewords.getRewordPoints()).isEqualTo(50L);
        assertThat(savedRewords.getTransactionId()).isEqualTo(8);
        assertThat(savedRewords.getDate()).isEqualTo((LocalDate.of(2025,6,6)));

    }

     /*
    This method tests the response summery for last 3 months for each customer.
     */
    @Test
    @DisplayName("Save reword Summery is obtained for over last 3 months")
    void testGetRewordSummeryForLastThreeMonth(){
        //Date for the range
        LocalDate endDate = LocalDate.now();
        //Date for the range
        LocalDate startDate = endDate.minusMonths(3);
        //Map for Summery
        Map<String , Integer> rewordSummeryByMonth = new HashMap<>();
        rewordSummeryByMonth.put("2025-05", 90);
        rewordSummeryByMonth.put("2025-04", 90);
        rewordSummeryByMonth.put("2025-06", 90);

        // Request Setup
        Rewords rewordRequest1 = new Rewords();
        rewordRequest1.setCustomerName("Adarsh");
        rewordRequest1.setCustomerId(123L);
        rewordRequest1.setTransactionAmount(120.00);

        // Response Setup
        Rewords rewordResponse1 = new Rewords();
        rewordResponse1.setCustomerName("Adarsh");
        rewordResponse1.setCustomerId(123L);
        rewordResponse1.setTransactionAmount(120.00);
        rewordResponse1.setRewordPoints(50L);
        rewordResponse1.setTransactionId(8);
        rewordResponse1.setDate((LocalDate.of(2025,6,6)));
//
//        // Request2 Setup
//        Rewords rewordRequest2 = new Rewords();
//        rewordRequest2.setCustomerName("Suraj");
//        rewordRequest2.setCustomerId(125L);
//        rewordRequest2.setTransactionAmount(120.00);

//        // Response2 Setup
//        Rewords rewordResponse2 = new Rewords();
//        rewordResponse2.setCustomerName("Suraj");
//        rewordResponse2.setCustomerId(125L);
//        rewordResponse2.setTransactionAmount(120.00);
//        rewordResponse2.setRewordPoints(50L);
//        rewordResponse2.setTransactionId(8);
//        rewordResponse2.setDate((LocalDate.of(2025,6,6)));

        // List Element 1
        RewordSummeryByCustomer response1 = new RewordSummeryByCustomer();
        response1.setCustomerName("Adarsh");
        response1.setCustomerId(123L);
        response1.setRewordPoints(rewordSummeryByMonth);
        response1.setTotalSumOfAllRewards(270L);


//        // List Element 2
//        RewordSummeryByCustomer response2 = new RewordSummeryByCustomer();
//        response1.setCustomerName("Suraj");
//        response1.setCustomerId(125L);
//        response1.setRewordPoints(rewordSummeryByMonth);
//        response1.setTotalSumOfAllRewards(270L);


        //Created List Of Rewords for last three months
        List<Rewords> testResultGetByLastThreeMonth = List.of(rewordRequest1);

        // Writing dummy logic for the repository layer
        Mockito.when(rewordsRepository.findByDateBetween(startDate,endDate)).thenReturn(testResultGetByLastThreeMonth);

        // Created list of summery for each customer for last 3 months.
        List<RewordSummeryByCustomer> rewordSummeryByCustomerListForLastThreeMonth = List.of(response1);

        //Getting the summery calculated
        Mockito.when(rewordsService.getRewordSummeryForLastThreeMonth()).thenReturn(rewordSummeryByCustomerListForLastThreeMonth);


        //Hitting repository layer for data retrieval of List.
        List<RewordSummeryByCustomer> rewordSummeryForLastThreeMonth = rewordsService.getRewordSummeryForLastThreeMonth();

        //Validations of Response.
        assertNotNull(rewordSummeryForLastThreeMonth);
        assertThat(rewordSummeryForLastThreeMonth.get(0).getCustomerName()).isEqualTo("Adarsh");
        assertThat(rewordSummeryForLastThreeMonth.get(0).getCustomerId()).isEqualTo(123L);
        assertThat(rewordSummeryForLastThreeMonth.get(0).getTotalSumOfAllRewards()).isEqualTo(270L);
        assertThat(rewordSummeryForLastThreeMonth.get(0).getRewordPoints()).isEqualTo(rewordSummeryForLastThreeMonth);


//        //Validations of Response second Element from the List.
//        assertNotNull(rewordSummeryForLastThreeMonth);
//        assertThat(rewordSummeryForLastThreeMonth.get(1).getCustomerName()).isEqualTo("Suraj");
//        assertThat(rewordSummeryForLastThreeMonth.get(1).getCustomerId()).isEqualTo(125L);
//        assertThat(rewordSummeryForLastThreeMonth.get(1).getTotalSumOfAllRewards()).isEqualTo(270L);
//        assertThat(rewordSummeryForLastThreeMonth.get(1).getRewordPoints()).isEqualTo(rewordSummeryForLastThreeMonth);


    }


    @Test
    @DisplayName("Testing Monthly Summery Reword Points Endpoint")
    void testfindRewordSummeryMonthlyByCustomerId(){


        Long customerId = 123L;
        List<Rewords> allrewords  = new ArrayList<>();

        Map<String , Integer> rewordSummeryByMonth = new HashMap<>();
        rewordSummeryByMonth.put("2025-06", 50);
//      rewordSummeryByMonth.put("2025-04", 90);
//      rewordSummeryByMonth.put("2025-06", 90);

        // Response Setup
        Rewords response = new Rewords();
        response.setCustomerName("Adarsh");
        response.setCustomerId(123L);
        response.setTransactionAmount(100.00);
        response.setRewordPoints(50L);
        response.setTransactionId(8);
        response.setDate((LocalDate.of(2025,6,6)));

        RewordSummeryByCustomer Summeryresponse1 = new RewordSummeryByCustomer();
        Summeryresponse1.setCustomerName("Adarsh");
        Summeryresponse1.setCustomerId(123L);
        Summeryresponse1.setRewordPoints(rewordSummeryByMonth);
        Summeryresponse1.setTotalSumOfAllRewards(270L);

        // Adding reword to list
        allrewords.add(response);

        //Mocking the Flow of Repository.
        when(rewordsRepository.findByCustomerId(123L)).thenReturn(allrewords);

        //Hitting repository layer for data retrieval.
        RewordSummeryByCustomer savedRewords = rewordsService.findRewordSummeryMonthlyByCustomerId(customerId);


        //Validations of Response.
        assertNotNull(savedRewords);
        assertThat(savedRewords.getCustomerName()).isEqualTo("Adarsh");
        assertThat(savedRewords.getCustomerId()).isEqualTo(123L);
        assertThat(savedRewords.getRewordPoints()).isEqualTo(rewordSummeryByMonth);


    }



    /*
    This method tests Save reword method of repository.
     */
    @Test
    @DisplayName("Unit Test for Getting Rewords By transactionId")
    void testgetRewordPoints(){

        // Response Setup
        Rewords response = new Rewords();
        response.setCustomerName("Adarsh");
        response.setCustomerId(123L);
        response.setTransactionAmount(100.00);
        response.setRewordPoints(50L);
        response.setTransactionId(8);
        response.setDate((LocalDate.of(2025,6,6)));

        // Writing Mock dummy logic for the repository layer
        Mockito.when(rewordsRepository.getById(Mockito.anyInt())).thenReturn(response);


        //Hitting repository layer for data retrieval.
        Rewords savedRewords = rewordsService.getRewordPoints(8);

        //Validations of Response.
        assertNotNull(savedRewords);
        assertThat(savedRewords.getCustomerName()).isEqualTo("Adarsh");
        assertThat(savedRewords.getCustomerId()).isEqualTo(123L);
        assertThat(savedRewords.getTransactionAmount()).isEqualTo(100);
        assertThat(savedRewords.getRewordPoints()).isEqualTo(50L);
        assertThat(savedRewords.getTransactionId()).isEqualTo(8);
        assertThat(savedRewords.getDate()).isEqualTo((LocalDate.of(2025,6,6)));

    }

}
