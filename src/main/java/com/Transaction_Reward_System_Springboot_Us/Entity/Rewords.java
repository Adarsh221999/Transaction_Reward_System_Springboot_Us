package com.Transaction_Reward_System_Springboot_Us.Entity;

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
public class Rewords {

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
    private Long rewordPoints;

    @Column(nullable = false , unique = false)
    private Long customerId;

    public Rewords() {}

    @Override
    public String toString() {
        return "Rewords{" +
                "tranzationId=" + transactionId +
                ", date=" + date +
                ", customerName='" + customerName + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", rewordPoints=" + rewordPoints +
                ", customerId=" + customerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rewords rewords = (Rewords) o;
        return Objects.equals(transactionId, rewords.transactionId) && Objects.equals(date, rewords.date) && Objects.equals(customerName, rewords.customerName) && Objects.equals(transactionAmount, rewords.transactionAmount) && Objects.equals(rewordPoints, rewords.rewordPoints) && Objects.equals(customerId, rewords.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, date, customerName, transactionAmount, rewordPoints, customerId);
    }
}
