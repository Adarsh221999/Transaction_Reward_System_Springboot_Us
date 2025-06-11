package com.Transaction_Reward_System_Springboot_Us.Controller;

import com.Transaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Transaction_Reward_System_Springboot_Us.Models.RewordSummeryByCustomer;
import com.Transaction_Reward_System_Springboot_Us.RewordService.RewordsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/reword")
public class RewordController {

    @Autowired
    RewordsServiceImpl rewordsService;

    private static final Logger logger = LoggerFactory.getLogger(RewordController.class);


    /*
    Controller endpoint for adding reword
     */
    @PostMapping (value = "/addReword")
    public ResponseEntity<?> addReword(@Valid @RequestBody Rewords request){
        Rewords rewords = null;
        try {
            logger.info("Received request to add reward: {}", request);
            rewords = rewordsService.addRewordPoints(request);
            logger.info("Completed request to add reward: {}", request);
            return new ResponseEntity<>(rewords, HttpStatus.OK);
        }
        catch (Exception e){
            logger.warn("Received Waring while request to add reward: {}", request);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }

    }




    /*
    Controller endpoint for getting reword by Reword/tranzactionId
     */
    @GetMapping(value = "/getrewordpoints/{rewordId}")
    public ResponseEntity<?> getRewordPoints(@Valid @PathVariable Integer rewordId){
        Rewords rewords = null;
        try {
            logger.info("Received request to get reword by tranzactionId: {}", rewordId);
            rewords = rewordsService.getRewordPoints(rewordId);
            logger.info("Completed request to get reword by the Id: {}", rewordId);
            return new ResponseEntity<>(rewords, HttpStatus.OK);
        }
        catch (Exception e){
            logger.warn("Exception request to get All reword by tranzactionId: {}", rewordId);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }

    }




    /*
    Controller endpoint for getting reword by customer Id
    */
    @GetMapping(value = "/getAllRewords/{CustomerId}")
    public ResponseEntity<?> getRewordPoints(@Valid @PathVariable Long CustomerId){

        List<Rewords> rewordsList=null;
        try {
            logger.info("Received request to get All reword by transactionId: {}", CustomerId);
            rewordsList = rewordsService.findByCustomerId(CustomerId);
            logger.info("Completed request to get All reword by transactionId: {}", CustomerId);

            return new ResponseEntity<>(rewordsList, HttpStatus.OK);
        }
        catch (Exception e){
            logger.info("Exception while request to get All reword by CustomerId: {}", CustomerId);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }
    }



    /*
    Controller endpoint for getting rewordpoints summery by month.
     */
    @GetMapping(value = "/getRewordsByMonth/{CustomerId}")
    public ResponseEntity<?> getRewordPointsSummery(@Valid @PathVariable Long CustomerId) {

        RewordSummeryByCustomer summery = null;

        try {
            logger.info("Received request to get All reword by Month CustomerId: {}", CustomerId);
            summery = rewordsService.findRewordSummeryMonthlyByCustomerId(CustomerId);
            logger.info("Completed request to get All reword by Month CustomerId: {}", CustomerId);

            return new ResponseEntity<>(summery, HttpStatus.OK);
        } catch (Exception e) {
            logger.warn("Exception while request to get All reword by Month CustomerId: {}", CustomerId);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }




    /*
    Controller endpoint for getting rewordpoints summery for last 3 months.
     */
        @GetMapping(value = "/getThreeMonthsRewordsSummeryForAllCustomer")
        public ResponseEntity<?> getThreeMonthsRewordsSummeryForAllCustomer() {

           // RewordSummeryByCustomer summeryThreeMonths = null;
            try {
                logger.info("Received request to get All reword summery for three months by each customer: {}");
                List<RewordSummeryByCustomer> threeMontsSummmery = rewordsService.getRewordSummeryForLastThreeMonth();
                logger.info("Received request to get All reword summery for three months by each customer:{}");

                return new ResponseEntity<>(threeMontsSummmery, HttpStatus.OK);
            } catch (Exception e) {
                logger.warn("Exception while getting all reword by customerId for three months: {}");
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

            }

        }

    }

