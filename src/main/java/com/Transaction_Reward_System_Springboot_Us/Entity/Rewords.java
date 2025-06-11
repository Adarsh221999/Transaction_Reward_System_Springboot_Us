package com.Transaction_Reward_System_Springboot_Us.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="Rewords" )
public class Rewords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tranzationId;

    @Column
    private LocalDate date;


    @Column
    @NotNull
    private String  customerName;

    @Column
    @NotNull
    private Double tranzationAmount;

    @Column
    private Long rewordPoints;

    @Column(nullable = false , unique = false)
    private Long customerId;

    public Integer getTranzationId() {
        return tranzationId;
    }

    public void setTranzationId(Integer tranzationId) {
        this.tranzationId = tranzationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTranzationAmount() {
        return tranzationAmount;
    }

    public void setTranzationAmount(Double tranzationAmount) {
        this.tranzationAmount = tranzationAmount;
    }

    public Long getRewordPoints() {
        return rewordPoints;
    }

    public void setRewordPoints(Long rewordPoints) {
        this.rewordPoints = rewordPoints;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Rewords() {}

    @Override
    public String toString() {
        return "Rewords{" +
                "tranzationId=" + tranzationId +
                ", date=" + date +
                ", customerName='" + customerName + '\'' +
                ", tranzationAmount=" + tranzationAmount +
                ", rewordPoints=" + rewordPoints +
                ", customerId=" + customerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rewords rewords = (Rewords) o;
        return Objects.equals(tranzationId, rewords.tranzationId) && Objects.equals(date, rewords.date) && Objects.equals(customerName, rewords.customerName) && Objects.equals(tranzationAmount, rewords.tranzationAmount) && Objects.equals(rewordPoints, rewords.rewordPoints) && Objects.equals(customerId, rewords.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tranzationId, date, customerName, tranzationAmount, rewordPoints, customerId);
    }
}
