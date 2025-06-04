package com.Tranzaction_Reward_System_Springboot_Us.RewordService;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;

public interface RewordOperations {

    public Rewords addRewordPoints (Rewords request);

    Rewords getRewordPoints(Integer rewordId);
}
