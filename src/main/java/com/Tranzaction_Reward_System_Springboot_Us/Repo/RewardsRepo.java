package com.Tranzaction_Reward_System_Springboot_Us.Repo;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardsRepo extends JpaRepository<Rewords,Integer> {

}
