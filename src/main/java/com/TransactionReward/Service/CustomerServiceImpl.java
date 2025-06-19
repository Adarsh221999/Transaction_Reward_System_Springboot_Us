package com.TransactionReward.Service;

import com.TransactionReward.Entity.Customer;
import com.TransactionReward.Exception.CustomerAlreadyExists;
import com.TransactionReward.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerOpreations {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer createCustomer(Customer customer) {
        Customer savedCustomer = null;
        try {
            if (customerRepo.findByCustomerName(customer.getCustomerName())!=null) {
                  throw new CustomerAlreadyExists("Customer already exist by same name");
            } else {
                savedCustomer = customerRepo.save(customer);
            }
        }
        catch (Exception e ){
           throw new RuntimeException(e);
        }
        return savedCustomer;
    }
}
