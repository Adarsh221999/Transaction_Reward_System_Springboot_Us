package com.Tranzaction_Reward_System_Springboot_Us.Models;

import jakarta.persistence.Column;

public class Reword_request {

    private String  customerName;
    private Integer tranzationId;
    private Double tranzation_Amount;
    private Long rewordPoints;

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

    public void setRewordPoints() {
        this.rewordPoints = calculateRewordsPoints(tranzation_Amount);
    }



    private static long calculateRewordsPoints(Double amount) {
        long calculated_Reword_Points=0;
        Long tranzation_amount = Math.round(amount);
        if (tranzation_amount>100)
        {
            calculated_Reword_Points+=(tranzation_amount-100)*2+(50*1);
        }
        else if (tranzation_amount>50 && tranzation_amount<100) {
            calculated_Reword_Points = (tranzation_amount-50)*1;
        }
        else {
            calculated_Reword_Points=0;
        }
        return calculated_Reword_Points;
    }


}
