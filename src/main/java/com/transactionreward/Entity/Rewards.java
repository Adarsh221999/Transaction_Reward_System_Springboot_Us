package com.transactionreward.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="Rewords" )
public class Rewards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @Column
    private LocalDate date;

    @Column
    @NotNull
    private String  customerName;

    @Column
    @NotNull
    private Double transactionAmount;

    @Column
    private Long rewardPoints;

   @ManyToOne(cascade = CascadeType.MERGE)
   @JoinColumn(name = "customer_id")
     private Customer customer;

    public Rewards() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewords = (Rewards) o;
        return Objects.equals(transactionId, rewords.transactionId) && Objects.equals(date, rewords.date) && Objects.equals(customerName, rewords.customerName) && Objects.equals(transactionAmount, rewords.transactionAmount) && Objects.equals(rewardPoints, rewords.rewardPoints) && Objects.equals(customer, rewords.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, date, customerName, transactionAmount, rewardPoints, customer);
    }

    @Override
    public String toString() {
        return "Rewords{" +
                "transactionId=" + transactionId +
                ", date=" + date +
                ", customerName='" + customerName + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", rewordPoints=" + rewardPoints +
                ", customer=" + customer +
                '}';
    }
}
