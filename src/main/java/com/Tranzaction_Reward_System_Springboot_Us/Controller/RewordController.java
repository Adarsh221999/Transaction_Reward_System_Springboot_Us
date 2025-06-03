package com.Tranzaction_Reward_System_Springboot_Us.Controller;

import com.Tranzaction_Reward_System_Springboot_Us.Models.Reword_responce;
import com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl.RewordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class RewordController {
    @Autowired
    RewordsServiceImpl rewordsService;

    @RequestMapping(value = "/getrewords/{amount}")
     public ResponseEntity<Reword_responce> getRewordPoints(@PathVariable Long amount){


        return null;
    }
}
