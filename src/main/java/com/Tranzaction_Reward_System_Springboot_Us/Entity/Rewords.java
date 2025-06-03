package com.Tranzaction_Reward_System_Springboot_Us.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="RewordsTable" )
public class Rewords {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rewordId;

    @Column
    private String  customerName;

    @Column
    private Integer tranzationId;

    @Column
    private Double tranzation_Amount;

    @Column
    private Long rewordPoints;


    public Integer getRewordId() {
        return rewordId;
    }

    public void setRewordId(Integer rewordId) {
        this.rewordId = rewordId;
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
        return tranzation_Amount;
    }

    public void setTranzation_Amount(Double tranzation_Amount) {
        this.tranzation_Amount = tranzation_Amount;
    }

    public Long getRewordPoints() {
        return rewordPoints;
    }

    public void setRewordPoints(Long rewordPoints) {
        this.rewordPoints = rewordPoints;
    }


    public Rewords(Integer rewordId, String customerName, Integer tranzationId, Double tranzation_Amount, Long rewordPoints) {
        this.rewordId = rewordId;
        this.customerName = customerName;
        this.tranzationId = tranzationId;
        this.tranzation_Amount = tranzation_Amount;
        this.rewordPoints = rewordPoints;
    }
}
