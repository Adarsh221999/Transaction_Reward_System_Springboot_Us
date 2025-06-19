package com.transactionreward;


import com.transactionreward.Repository.RewardsRepo;
import com.transactionreward.Service.RewardsServiceImpl;
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
