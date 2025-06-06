package com.Tranzaction_Reward_System_Springboot_Us;


import com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl.RewordsServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockServiceConfig {

    @Bean
    public RewordsServiceImpl rewordsService() {
        return Mockito.mock(RewordsServiceImpl.class);
    }
}
