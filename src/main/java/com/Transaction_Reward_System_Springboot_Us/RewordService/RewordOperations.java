package com.Transaction_Reward_System_Springboot_Us.RewordService;

import com.Transaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Transaction_Reward_System_Springboot_Us.Models.RewordSummeryByCustomer;

import java.util.List;

public interface RewordOperations {

    public Rewords addRewordPoints (Rewords request);

    Rewords getRewordPoints(Integer rewordId);

    List<Rewords> findByCustomerId(Long customerId);

    RewordSummeryByCustomer findRewordSummeryMonthlyByCustomerId(Long customerId);

}
