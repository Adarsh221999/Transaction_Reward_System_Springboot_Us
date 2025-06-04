package com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
//import com.Tranzaction_Reward_System_Springboot_Us.Models.Reword_request;
import com.Tranzaction_Reward_System_Springboot_Us.Repo.RewardsRepo;
import com.Tranzaction_Reward_System_Springboot_Us.RewordService.RewordOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewordsServiceImpl implements RewordOperations {

    @Autowired
    private RewardsRepo repo;

    public Rewords addRewordPoints(Rewords rewords) {
        Rewords savedReword=null;
        try {
            rewords.setRewordPoints(calculateRewordsPoints(rewords.getTranzation_Amount()));
            System.out.print(rewords.toString());
            savedReword = repo.save(rewords);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return savedReword;
    }


    @Override
    public Rewords getRewordPoints(Integer rewordId) {
        Rewords getRewordsById=null;
        try {
            getRewordsById= repo.getById(rewordId);
            return  getRewordsById;
        }
        catch (Exception e ){
            System.out.println(e.getCause());
        }
        return getRewordsById;
    }

    private static Long calculateRewordsPoints(Double amount) {
        long calculated_Reword_Points = 0;
        try {
            long tranzation_amount = Math.round(amount);
            if (tranzation_amount > 100) {
                calculated_Reword_Points += (tranzation_amount - 100) * 2 + (50 * 1);
            } else if (tranzation_amount > 50 && tranzation_amount < 100) {
                calculated_Reword_Points = (tranzation_amount - 50) * 1;
            } else {
                calculated_Reword_Points = 0;
            }

        }
        catch(Exception e){
             System.out.print(e);
        }

        return calculated_Reword_Points;
    }

}
