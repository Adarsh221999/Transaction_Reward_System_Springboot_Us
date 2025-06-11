package com.Transaction_Reward_System_Springboot_Us.Exception;


/*
Exception for Failed to get the reword Summery for last three months.
 */
public class FailedToGetRewordSummeryForLastThreeMonth extends RuntimeException {
    public FailedToGetRewordSummeryForLastThreeMonth(String message) {
        super(message);
    }
}
