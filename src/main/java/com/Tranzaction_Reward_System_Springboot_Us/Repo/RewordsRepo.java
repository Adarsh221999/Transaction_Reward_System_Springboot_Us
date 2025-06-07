package com.Tranzaction_Reward_System_Springboot_Us.Repo;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewordsRepo extends JpaRepository<Rewords,Integer> {

    List<Rewords> findByCustomerId(Long CustomerId);


}
