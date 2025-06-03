package com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl;

import com.Tranzaction_Reward_System_Springboot_Us.Repo.RewardsRepo;
import com.Tranzaction_Reward_System_Springboot_Us.RewordService.RewordOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewordsServiceImpl implements RewordOperations {

    @Autowired
    private RewardsRepo repo;



}
