package com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl;

import com.Tranzaction_Reward_System_Springboot_Us.RewordService.RewordOperations;

public class RewordsServiceImpl implements RewordOperations {

    @Override
    public long calculateRewordsPoints(Double amount) {
        long calculated_Reword_Points=0;
        Long tranzation_amount = Math.round(amount);
        if (tranzation_amount>100)
        {
            calculated_Reword_Points+=(tranzation_amount-100)*2+(50*1);
        }
        else if (tranzation_amount>50 && tranzation_amount<100) {
             calculated_Reword_Points = (tranzation_amount-50)*1;
        }
        else {
            calculated_Reword_Points=0;
        }
        return calculated_Reword_Points;
    }
}
