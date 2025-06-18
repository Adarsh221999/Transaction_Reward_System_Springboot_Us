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
    private List<Map<String,Object>> transactionList;
    private List<Map<String,Object>>rewordPoints;
    private Long totalSumOfAllRewards;

    public RewardSummeryByCustomer(String  customerName,List<Map<String,Object>> transactionList, List<Map<String,Object>> rewordPoints, Long totalSumOfAllRewards) {
        this.customerName = customerName;
        this.transactionList = transactionList;
        this.rewordPoints = rewordPoints;
        this.totalSumOfAllRewards = totalSumOfAllRewards;
    }

    @Override
    public String toString() {
        return "RewardSummeryByCustomer{" +
                "customerName='" + customerName + '\'' +
                ", transactionList=" + transactionList +
                ", rewordPoints=" + rewordPoints +
                ", totalSumOfAllRewards=" + totalSumOfAllRewards +
                '}';
    }

    public RewardSummeryByCustomer() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RewardSummeryByCustomer that = (RewardSummeryByCustomer) o;
        return Objects.equals(transactionList, that.transactionList) && Objects.equals(rewordPoints, that.rewordPoints) && Objects.equals(totalSumOfAllRewards, that.totalSumOfAllRewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionList, rewordPoints, totalSumOfAllRewards);
    }



}
