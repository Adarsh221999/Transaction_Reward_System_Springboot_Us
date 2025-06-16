package com.Transaction_Reward_System_Springboot_Us.Service;

import com.Transaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Transaction_Reward_System_Springboot_Us.Models.RewordSummeryByCustomer;

import java.time.LocalDate;
import java.util.List;

public interface RewordOperations {

    /*
    Repository method to add rewords in rewords table
     */
    public Rewords addRewordPoints (Rewords request);


    /*
      Repository method to get rewords in rewords table by reword transactionId
     */
    Rewords getRewordPoints(Integer rewordId);


    /*
     Repository method to find rewords in rewords table by customer id
     */
    List<Rewords> findByCustomerId(Long customerId);


    /*
       Repository method to get rewords summery by customer id in Rewords table.
     */
    RewordSummeryByCustomer findRewordSummeryMonthlyByCustomerId(Long customerId, LocalDate startDate , LocalDate endDate);





}
