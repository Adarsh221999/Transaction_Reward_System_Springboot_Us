package com.Transaction_Reward_System_Springboot_Us.Repository;

import com.Transaction_Reward_System_Springboot_Us.Entity.Rewords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewordsRepo extends JpaRepository<Rewords,Integer> {

      /*
    This method finds the reword transactions by customerId
     */
    List<Rewords> findByCustomerId(Long CustomerId);

}
