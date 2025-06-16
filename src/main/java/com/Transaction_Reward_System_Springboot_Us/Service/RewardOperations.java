package com.Transaction_Reward_System_Springboot_Us.Service;

import com.Transaction_Reward_System_Springboot_Us.Entity.Rewards;
import com.Transaction_Reward_System_Springboot_Us.Models.RewardSummeryByCustomer;

import java.time.LocalDate;
import java.util.List;

public interface RewardOperations {

    /*
    Repository method to add rewords in rewords table
     */
    public Rewards addRewardPoints(Rewards request);


    /*
      Repository method to get rewords in rewords table by reword transactionId
     */
    Rewards getRewardPoints(Integer rewordId);


    /*
     Repository method to find rewords in rewords table by customer id
     */
    List<Rewards> findByCustomerId(Long customerId);


    /*
       Repository method to get rewords summery by customer id in Rewords table.
     */
    RewardSummeryByCustomer findRewardSummeryMonthlyByCustomerId(Long customerId, LocalDate startDate, LocalDate endDate);


    /*
      Method for the calculation for the reword Summery points by Customer ID.
    */
    public List<RewardSummeryByCustomer> getRewardsummeryForLastThreeMonth(LocalDate StartDate, LocalDate EndDate);
  }

