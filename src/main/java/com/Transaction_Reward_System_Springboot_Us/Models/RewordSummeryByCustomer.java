package com.Transaction_Reward_System_Springboot_Us.Models;

import java.util.Map;
import java.util.Objects;

public class RewordSummeryByCustomer {

    private String  customerName;
    private Long customerId;
    private Map<String, Integer> rewordPoints;
    private Long totalSumOfAllRewards;


    public Long getTotalSumOfAllRewards() {
        return totalSumOfAllRewards;
    }

    public void setTotalSumOfAllRewards(Long totalSumOfAllRewards) {
        this.totalSumOfAllRewards = totalSumOfAllRewards;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Map<String, Integer> getRewordPoints() {
        return rewordPoints;
    }

    public void setRewordPoints(Map<String,Integer> rewordPoints) {
        this.rewordPoints = rewordPoints;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public RewordSummeryByCustomer(String customerName, Map<String, Integer> rewordPoints, Long customerId) {
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

    public RewordSummeryByCustomer() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RewordSummeryByCustomer that = (RewordSummeryByCustomer) o;
        return Objects.equals(customerName, that.customerName) && Objects.equals(rewordPoints, that.rewordPoints) && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, rewordPoints, customerId);
    }
}
