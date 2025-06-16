package com.Transaction_Reward_System_Springboot_Us.Repository;

import com.Transaction_Reward_System_Springboot_Us.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

    /*
    Method for the finding the customer if already exist by name
     */
    Customer findByCustomerName(String name);
}
