package com.Tranzaction_Reward_System_Springboot_Us.Controller;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Tranzaction_Reward_System_Springboot_Us.Models.Reword_request;
import com.Tranzaction_Reward_System_Springboot_Us.Models.Reword_responce;
import com.Tranzaction_Reward_System_Springboot_Us.Repo.RewardsRepo;
import com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl.RewordsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

public class RewordController {
    @Autowired
    RewordsServiceImpl rewordsService;
    @Autowired
    Reword_request rewardRequest;

    @RequestMapping(value = "/getrewords/{amount}")
     public ResponseEntity<Rewords> getRewordPoints(@PathVariable Long amount , @RequestBody HttpServletRequest request){
        Rewords rewords = null;
       try {
           Reword_request rewardsRequest = rewardRequest.mapToRewordRequest(request);
           rewords = rewordsService.addRewordPoints(rewardsRequest);
           return new ResponseEntity<>(rewords, HttpStatus.OK);
       }
       catch (Exception e ){
           System.out.print(e);

       }

        return new ResponseEntity<>(rewords,HttpStatus.BAD_REQUEST);
    }
}
