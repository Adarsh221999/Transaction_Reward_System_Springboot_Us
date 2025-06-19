package com.TransactionReward.Controller;

import com.TransactionReward.Entity.Rewards;
import com.TransactionReward.Exception.RewordTransactionNotFound;
import com.TransactionReward.Models.RewardSummeryByCustomer;
import com.TransactionReward.Service.RewardsServiceImpl;
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
@RequestMapping("/reward")
public class RewardController {

    @Autowired
    RewardsServiceImpl rewardsService;

    private static final Logger logger = LoggerFactory.getLogger(RewardController.class);

    /*
    Controller endpoint for adding reword
    Request Body Contains the user request body for adding reword.
    */
    @PostMapping (value = "/addReward")
    public ResponseEntity<Rewards> addReword(@Valid @RequestBody Rewards request){
        Rewards rewards = null;
        try {
            logger.info("Received request to add reward: {}", request);
            rewards = rewardsService.addRewardPoints(request);
            logger.info("Completed request to add reward: {}", request);
            return new ResponseEntity<>(rewards, HttpStatus.OK);
        }
        catch (Exception e){
            logger.warn("Received Waring while request to add reward: {}", request);
            throw new RewordTransactionNotFound("Failed to Generate reward transaction ");


        }

    }

    /*
      Controller endpoint for getting reword points summery by month for given customer id.
    * @Pathvariable CustomerId coming for user request.
    */
    @GetMapping(value = "/getRewardsByMonth/{CustomerId}")
    public ResponseEntity<RewardSummeryByCustomer> getRewordPointsSummery(
            @Valid @PathVariable Long CustomerId,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate StartDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate EndDate
            )
    {
        RewardSummeryByCustomer summery = null;
        try {
            logger.info("Received request to get All reword by Month CustomerId: {}", CustomerId);
            summery = rewardsService.findRewardSummeryMonthlyByCustomerId(CustomerId,StartDate,EndDate);
            logger.info("Completed request to get All reword by Month CustomerId: {}", CustomerId);

            return new ResponseEntity<>(summery, HttpStatus.OK);
        } catch (Exception e) {
            logger.warn("Exception while request to get All reword by Month CustomerId: {}", CustomerId);
            throw new RewordTransactionNotFound("Failed to Generate reward transaction Summery");


        }

    }

    /*
    Controller endpoint for getting rewordpoints summery for last 3 months.
    * Do not take any argument.
    */
        @GetMapping(value = "/getThreeMonthsrewardsSummeryForAllCustomer")
        public ResponseEntity<List<RewardSummeryByCustomer>> getThreeMonthsrewardsSummeryForAllCustomer
        (
         @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate StartDate,
         @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate EndDate
         ) {

            try {
                logger.info("Received request to get All reword summery for three months by each customer: {1}");
                List<RewardSummeryByCustomer> threeMonthsSummery = rewardsService.getRewardsummeryForLastThreeMonth(StartDate ,EndDate );
                logger.info("Received request to get All reword summery for three months by each customer:{1}");

                return new ResponseEntity<>(threeMonthsSummery, HttpStatus.OK);
            } catch (Exception e) {
                logger.warn("Exception while getting all reword by customerId for three months: {1}");
                throw new RewordTransactionNotFound("Failed to Generate reward transaction ");

            }

        }

    }

