package com.Tranzaction_Reward_System_Springboot_Us;


import com.Tranzaction_Reward_System_Springboot_Us.Repo.RewordsRepo;
import com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl.RewordsServiceImpl;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TestConfiguration
public class MockServiceConfig {

    @Bean
    public RewordsRepo getRewordsRepo(){
        return Mockito.mock(RewordsRepo.class);
    }

    @Bean
    public RewordsServiceImpl rewordsService() {
        return new RewordsServiceImpl(getRewordsRepo());
    }
}
