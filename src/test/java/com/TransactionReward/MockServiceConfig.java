package com.TransactionReward;


import com.TransactionReward.Repository.RewardsRepo;
import com.TransactionReward.Service.RewardsServiceImpl;
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
