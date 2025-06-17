package com.Transaction_Reward_System_Springboot_Us.Models;

import com.Transaction_Reward_System_Springboot_Us.Entity.Rewards;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class RewardSummeryByCustomer {

    private String  customerName;
    private Long customerId;
    private List<Rewards> transactionList;
    private Set<Map.Entry<String, Integer>>rewordPoints;
    private Long totalSumOfAllRewards;


    public RewardSummeryByCustomer(String customerName, Set<Map.Entry<String, Integer>> rewordPoints, Long customerId) {
        this.customerName = customerName;
        this.rewordPoints = rewordPoints;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "RewordSummeryByCustomer{" +
                "customerName='" + customerName + '\'' +
                ", rewordPoints=" + rewordPoints +
                ", customerId=" + customerId +
                '}';
    }

    public RewardSummeryByCustomer() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RewardSummeryByCustomer that = (RewardSummeryByCustomer) o;
        return Objects.equals(customerName, that.customerName) && Objects.equals(rewordPoints, that.rewordPoints) && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, rewordPoints, customerId);
    }
}
