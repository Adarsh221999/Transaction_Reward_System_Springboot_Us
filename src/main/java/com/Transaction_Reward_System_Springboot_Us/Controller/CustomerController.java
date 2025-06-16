package com.Transaction_Reward_System_Springboot_Us.Controller;

import com.Transaction_Reward_System_Springboot_Us.Entity.Customer;
import com.Transaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Transaction_Reward_System_Springboot_Us.Service.CustomerServiceImpl;
import com.Transaction_Reward_System_Springboot_Us.Service.RewordsServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    // Autowired Service Layer Implementation.
    @Autowired
    CustomerServiceImpl customerService;

    // Logger for the class to log appropriate messages.
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    /*
    Controller endpoint for adding reword
    Request Body Contains the user request body for adding reword.
    */
    @PostMapping(value = "/addCustomer")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer request){
        Rewords rewords = null;
        try {
            logger.info("Adding customer in progress: {}", request);
            Customer SavedCustomer= customerService.addCustomer(request);
            logger.info("Completed request to add Customer: {}", request);
            return new ResponseEntity<>(SavedCustomer, HttpStatus.OK);
        }
        catch (Exception e){
            logger.warn("Adding customer in progress: {}", request);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }

    }



}
