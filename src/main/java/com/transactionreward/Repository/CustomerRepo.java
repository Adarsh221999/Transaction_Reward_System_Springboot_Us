package com.transactionreward.Repository;

import com.transactionreward.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

    /*
    Method for the finding the customer if already exist by name
     */
    Customer findByCustomerName(String name);
}
