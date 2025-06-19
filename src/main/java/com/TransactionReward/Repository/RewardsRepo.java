package com.TransactionReward.Repository;

import com.TransactionReward.Entity.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RewardsRepo extends JpaRepository<Rewards,Integer> {

    /*
    This method finds the reword transactions by CustomerId
    CustomerId -
     */
    List<Rewards> findByCustomerId(Long CustomerId);


    /*
    This method finds the reword transactions by date range.
     */
    List<Rewards>findByDateBetween(LocalDate startDate,LocalDate EndDate);

}
