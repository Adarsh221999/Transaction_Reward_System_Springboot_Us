package com.Transaction_Reward_System_Springboot_Us;


import com.Transaction_Reward_System_Springboot_Us.Repository.RewordsRepo;
import com.Transaction_Reward_System_Springboot_Us.RewordService.RewordsServiceImpl;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

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
