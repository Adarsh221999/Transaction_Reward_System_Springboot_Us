package com.Transaction_Reward_System_Springboot_Us.Service;

import com.Transaction_Reward_System_Springboot_Us.Entity.Customer;
import com.Transaction_Reward_System_Springboot_Us.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerOpreations {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }
}
