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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/rewords")
public class RewordController {

    @Autowired
    RewordsServiceImpl rewordsService;

    private static Logger logger = LoggerFactory.getLogger(RewordController.class);

    @PostMapping (value = "/addReword")
    public ResponseEntity<Rewords> addReword(@Valid @RequestBody Rewords request){
        Rewords rewords = null;
        try {
            logger.info("Received request to add reward: {}", request);
            rewords = rewordsService.addRewordPoints(request);
            logger.info("Completed request to add reward: {}", request);
            return new ResponseEntity<>(rewords, HttpStatus.OK);
        }
        catch (Exception e ){
            logger.warn("Received Waring while request to add reward: {}", request);
            System.out.print(e);

        }
        return new ResponseEntity<>(rewords,HttpStatus.BAD_REQUEST);
    }


    @GetMapping(value = "/getrewordpoints/{rewordId}")
    public ResponseEntity<Rewords> getRewordPoints(@Valid @PathVariable Integer rewordId){
        Rewords rewords = null;
        try {
            logger.info("Received request to get reword by tranzactionId: {}", rewordId);
            rewords = rewordsService.getRewordPoints(rewordId);
            logger.info("Completed request to get reword by the Id: {}", rewordId);
            return new ResponseEntity<>(rewords, HttpStatus.OK);
        }
        catch (Exception e ){
            logger.warn("Exception request to get All reword by tranzactionId: {}", rewordId);
            System.out.print(e);

        }
        return new ResponseEntity<>(rewords,HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/getAllRewords/{CustomerId}")
    public ResponseEntity<List<Rewords>> getRewordPoints(@Valid @PathVariable Long CustomerId){

        List<Rewords> rewordsList=null;
        try {
            logger.info("Received request to get All reword by tranzactionId: {}", CustomerId);
            rewordsList = rewordsService.findByCustomerId(CustomerId);
            logger.info("Completed request to get All reword by tranzactionId: {}", CustomerId);

            return new ResponseEntity<>(rewordsList, HttpStatus.OK);
        }
        catch (Exception e ){
            logger.info("Exception while request to get All reword by CustomerId: {}", CustomerId);
            System.out.print(e);

        }
        return new ResponseEntity<>(rewordsList,HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getRewordsByMonth/{CustomerId}")
    public ResponseEntity<RewordSummeryByCustomer> getRewordPointsSummery(@Valid @PathVariable Long CustomerId){

         RewordSummeryByCustomer summery=null;

        try {
            logger.info("Received request to get All reword by Month CustomerId: {}", CustomerId);
            summery = rewordsService.findRewordSummeryMonthlyByCustomerId(CustomerId);
            logger.info("Completed request to get All reword by Month CustomerId: {}", CustomerId);

            return new ResponseEntity<>(summery, HttpStatus.OK);
        }
        catch (Exception e ){
            logger.warn("Exception while request to get All reword by Month CustomerId: {}", CustomerId);
            System.out.print(e);

        }
        return new ResponseEntity<>(summery,HttpStatus.NOT_FOUND);
    }
}
