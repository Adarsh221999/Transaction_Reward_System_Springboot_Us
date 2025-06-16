package com.Transaction_Reward_System_Springboot_Us;


import com.Transaction_Reward_System_Springboot_Us.Repository.RewardsRepo;
import com.Transaction_Reward_System_Springboot_Us.Service.RewardsServiceImpl;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MockServiceConfig {

    @Bean
    public RewardsRepo getRewardsRepo(){
        return Mockito.mock(RewardsRepo.class);
    }

    @Bean
    public RewardsServiceImpl RewardsService() {
        return new RewardsServiceImpl(getRewardsRepo());
    }
}
