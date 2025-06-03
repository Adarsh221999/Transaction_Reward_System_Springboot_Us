package com.Tranzaction_Reward_System_Springboot_Us.RewordService;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Tranzaction_Reward_System_Springboot_Us.Models.Reword_request;

public interface RewordOperations {

    public Rewords addRewordPoints (Reword_request request);

}
