package com.Tranzaction_Reward_System_Springboot_Us.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="Rewords" )
public class Rewords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tranzationId;

    @Column
    @NotNull
    private String  customerName;

    @Column
    @NotNull
    private Double tranzationAmount;

    @Column
    private Long rewordPoints;

    @Column(nullable = true , unique = false)
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    public String getCustomerName() {

        return customerName;
    }

    public void setCustomerName(String customerName) {

        this.customerName = customerName;
    }

    public Integer getTranzationId() {

        return tranzationId;
    }

    public void setTranzationId(Integer tranzationId) {

        this.tranzationId = tranzationId;
    }

    public Double getTranzation_Amount() {

        return tranzationAmount;
    }

    public void setTranzation_Amount(Double tranzation_Amount) {
        this.tranzationAmount = tranzation_Amount;
    }

    public Long getRewordPoints() {

        return rewordPoints;
    }

    public void setRewordPoints(Long rewordPoints) {

        this.rewordPoints = rewordPoints;
    }

    public Rewords(Integer rewordId, String customerName, Integer tranzationId, Double tranzation_Amount, Long rewordPoints,Long customerId) {
       // this.rewordId = rewordId;
        this.customerId=customerId;
        this.customerName = customerName;
        this.tranzationId = tranzationId;
        this.tranzationAmount = tranzation_Amount;
        this.rewordPoints = rewordPoints;
    }

    public Rewords() {}


}
