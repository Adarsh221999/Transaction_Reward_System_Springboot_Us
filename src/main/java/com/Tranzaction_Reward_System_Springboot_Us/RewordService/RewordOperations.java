package com.Tranzaction_Reward_System_Springboot_Us.RewordService;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Tranzaction_Reward_System_Springboot_Us.Models.RewordSummeryByCustomer;
import jakarta.validation.Valid;

import java.util.List;

public interface RewordOperations {

    public Rewords addRewordPoints (Rewords request);

    Rewords getRewordPoints(Integer rewordId);

    List<Rewords> findByCustomerId(Long customerId);

    RewordSummeryByCustomer findRewordSummeryMonthlyByCustomerId(Long customerId);


    //Rewords getRewordPointsByMonth(Long customerId);
}
