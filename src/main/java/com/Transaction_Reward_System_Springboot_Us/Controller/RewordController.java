package com.Transaction_Reward_System_Springboot_Us.Controller;

import com.Transaction_Reward_System_Springboot_Us.Entity.Rewards;
import com.Transaction_Reward_System_Springboot_Us.Models.RewardSummeryByCustomer;
import com.Transaction_Reward_System_Springboot_Us.Service.RewardsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reword")
public class RewordController {

    @Autowired
    RewardsServiceImpl rewordsService;

    private static final Logger logger = LoggerFactory.getLogger(RewordController.class);

    /*
    Controller endpoint for adding reword
    Request Body Contains the user request body for adding reword.
    */
    @PostMapping (value = "/addReword")
    public ResponseEntity<?> addReword(@Valid @RequestBody Rewards request){
        Rewards rewords = null;
        try {
            logger.info("Received request to add reward: {}", request);
            rewords = rewordsService.addRewardPoints(request);
            logger.info("Completed request to add reward: {}", request);
            return new ResponseEntity<>(rewords, HttpStatus.OK);
        }
        catch (Exception e){
            logger.warn("Received Waring while request to add reward: {}", request);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }

    }

    /*
    Controller endpoint for getting reword by Reword/transactionId
    * @Path variable from request to get generated rewords by the past transaction ID
    */
    @GetMapping(value = "/getrewordpoints/{rewordId}")
    public ResponseEntity<?> getRewordPoints(@Valid @PathVariable Integer rewordId){
        Rewards rewords = null;
        try {
            logger.info("Received request to get reword by tranzactionId: {}", rewordId);
            rewords = rewordsService.getRewardPoints(rewordId);
            logger.info("Completed request to get reword by the Id: {}", rewordId);
            return new ResponseEntity<>(rewords, HttpStatus.OK);
        }
        catch (Exception e){
            logger.warn("Exception request to get All reword by tranzactionId: {}", rewordId);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }

    }

    /*
    Controller endpoint for getting reword by customer id
    * @PathVariable - CustomerId for identifying the by its id
    */
    @GetMapping(value = "/getAllRewords/{CustomerId}")
    public ResponseEntity<?> getRewordPoints(@Valid @PathVariable Long CustomerId){

        List<Rewards> rewordsList=null;
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
      Controller endpoint for getting reword points summery by month for given customer id.
    * @Pathvariable CustomerId coming for user request.
    */
    @GetMapping(value = "/getRewordsByMonth/{CustomerId}")
    public ResponseEntity<?> getRewordPointsSummery(
            @Valid @PathVariable Long CustomerId,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate StartDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate EndDate
            )
    {

        RewardSummeryByCustomer summery = null;

        try {
            logger.info("Received request to get All reword by Month CustomerId: {}", CustomerId);
            summery = rewordsService.findRewardSummeryMonthlyByCustomerId(CustomerId,StartDate,EndDate);
            logger.info("Completed request to get All reword by Month CustomerId: {}", CustomerId);

            return new ResponseEntity<>(summery, HttpStatus.OK);
        } catch (Exception e) {
            logger.warn("Exception while request to get All reword by Month CustomerId: {}", CustomerId);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }

    /*
    Controller endpoint for getting rewordpoints summery for last 3 months.
    * Do not take any argument.
    */
        @GetMapping(value = "/getThreeMonthsRewordsSummeryForAllCustomer")
        public ResponseEntity<?> getThreeMonthsRewordsSummeryForAllCustomer
        (
         @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate StartDate,
         @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate EndDate
         ) {

           // RewordSummeryByCustomer summeryThreeMonths = null;
            try {
                logger.info("Received request to get All reword summery for three months by each customer: {}");
                List<RewardSummeryByCustomer> threeMontsSummmery = rewordsService.getRewardsummeryForLastThreeMonth(StartDate ,EndDate );
                logger.info("Received request to get All reword summery for three months by each customer:{}");

                return new ResponseEntity<>(threeMontsSummmery, HttpStatus.OK);
            } catch (Exception e) {
                logger.warn("Exception while getting all reword by customerId for three months: {}");
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

            }

        }

    }

