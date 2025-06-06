package com.Tranzaction_Reward_System_Springboot_Us.Controller;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Tranzaction_Reward_System_Springboot_Us.Models.RewordSummeryByCustomer;
import com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl.RewordsServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rewords")
public class RewordController {

    @Autowired
    RewordsServiceImpl rewordsService;


    @PostMapping (value = "/addReword")
    public ResponseEntity<Rewords> addReword(@Valid @RequestBody Rewords request){
        Rewords rewords = null;
        try {
            rewords = rewordsService.addRewordPoints(request);
            return new ResponseEntity<>(rewords, HttpStatus.OK);
        }
        catch (Exception e ){
            System.out.print(e);

        }
        return new ResponseEntity<>(rewords,HttpStatus.BAD_REQUEST);
    }


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
        return new ResponseEntity<>(rewords,HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/getAllRewords/{CustomerId}")
    public ResponseEntity<List<Rewords>> getRewordPoints(@Valid @PathVariable Long CustomerId){

        List<Rewords> rewordsList=null;
        try {
             rewordsList = rewordsService.findByCustomerId(CustomerId);
            return new ResponseEntity<>(rewordsList, HttpStatus.OK);
        }
        catch (Exception e ){
            System.out.print(e);

        }
        return new ResponseEntity<>(rewordsList,HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getRewordsByMonth/{CustomerId}")
    public ResponseEntity<?> getRewordPointsSummery(@Valid @PathVariable Long CustomerId){

         RewordSummeryByCustomer summery=null;

        try {
            summery = rewordsService.findRewordSummeryMonthlyByCustomerId(CustomerId);
            return new ResponseEntity<>(summery, HttpStatus.OK);
        }
        catch (Exception e ){
            System.out.print(e);

        }
        return new ResponseEntity<>(summery,HttpStatus.NOT_FOUND);
    }
}
