package com.Tranzaction_Reward_System_Springboot_Us.Controller;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl.RewordsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rewords")
public class RewordController {

    @Autowired
    RewordsServiceImpl rewordsService;



    @GetMapping(value = "/getrewordpoints/{rewordId}")
    public ResponseEntity<Rewords> getRewordPoints(@Valid @PathVariable Integer rewordId){
        Rewords rewords = null;
        try {
            rewords = rewordsService.getRewordPoints(rewordId);
            return new ResponseEntity<>(rewords, HttpStatus.OK);
        }
        catch (Exception e ){
            System.out.print(e);

        }
        return new ResponseEntity<>(rewords,HttpStatus.OK);
    }
}
