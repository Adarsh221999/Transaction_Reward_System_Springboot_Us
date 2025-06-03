package com.Tranzaction_Reward_System_Springboot_Us.Models;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import jakarta.persistence.Column;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.net.http.HttpRequest;

@Component
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

    public void setRewordPoints(Long rewordPoints) {
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


    public Reword_request mapToRewordRequest(HttpServletRequest request) {
        Reword_request reword_request = new Reword_request();
        reword_request.setCustomerName(request.getParameter("customerName"));
        reword_request.setTranzationId(Integer.valueOf(request.getParameter("tranzationId")));
        reword_request.setTranzation_Amount(Double.valueOf(Integer.valueOf(request.getParameter("tranzation_Amount"))));

        reword_request.setRewordPoints(calculateRewordsPoints(Double.valueOf(request.getParameter("tranzation_Amount"))));
        return reword_request;
    }

    public Rewords mapToRewordEntity(Reword_request request){
      Rewords reward = new Rewords();
      reward.setRewordPoints(request.getRewordPoints());
      reward.setTranzationId(request.getTranzationId());
      reward.setCustomerName(request.getCustomerName());
      reward.setTranzation_Amount(request.getTranzation_Amount());


     return reward;
    }

}
