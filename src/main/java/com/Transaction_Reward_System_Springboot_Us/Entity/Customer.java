package com.Transaction_Reward_System_Springboot_Us.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Table
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long customer_id;

    @Column
    String customerName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Rewords> rewords = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customer_id, customer.customer_id) && Objects.equals(customerName, customer.customerName) && Objects.equals(rewords, customer.rewords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, customerName, rewords);
    }
}
