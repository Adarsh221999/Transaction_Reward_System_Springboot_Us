package com.Tranzaction_Reward_System_Springboot_Us.RewordServiceImpl;

import com.Tranzaction_Reward_System_Springboot_Us.Entity.Rewords;
import com.Tranzaction_Reward_System_Springboot_Us.Exception.CustomerNotFoundException;
import com.Tranzaction_Reward_System_Springboot_Us.Models.RewordSummeryByCustomer;
import com.Tranzaction_Reward_System_Springboot_Us.Repo.RewordsRepo;
import com.Tranzaction_Reward_System_Springboot_Us.Repo.RewordsRepo;
import com.Tranzaction_Reward_System_Springboot_Us.RewordService.RewordOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RewordsServiceImpl implements RewordOperations {

    @Autowired
    private RewordsRepo repo;

    public RewordsServiceImpl(RewordsRepo rewordsRepo) {
    }

    @Override
    public List<Rewords> findByCustomerId(Long CustomerId) {
        return repo.findByCustomerId(CustomerId);
    }

    public Rewords addRewordPoints(Rewords rewords) {
        Rewords savedReword=null;
        try {
            rewords.setRewordPoints(calculateRewordsPoints(rewords.getTranzationAmount()));
            rewords.setDate(LocalDate.now());
            System.out.print(rewords.toString());
            savedReword=repo.save(rewords);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return savedReword;
    }

    @Override
    public Rewords getRewordPoints(Integer rewordId) {
        Rewords getRewordsById=null;
        try {
            getRewordsById= repo.getById(rewordId);
            return  getRewordsById;
        }
        catch (Exception e ){
            System.out.println(e.getCause());
        }
        return getRewordsById;
    }



    @Override
    public RewordSummeryByCustomer findRewordSummeryMonthlyByCustomerId(Long customerId) {
        RewordSummeryByCustomer summery = new RewordSummeryByCustomer();
        List<Rewords> allrewords=null;
        try
        {

          Long totalPoints= 0L;

          try {
               allrewords = repo.findByCustomerId(customerId);
          }
          catch (CustomerNotFoundException e){
              System.out.println(e.getMessage());
          }
          if (allrewords.size()==0){throw  new CustomerNotFoundException("No Customer with the id "+customerId);}
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
            totalPoints=allrewords.stream().mapToLong(points->points.getRewordPoints()).sum();
            summery.setTotalSumOfAllRewards(totalPoints);
            Map<String, Integer>RewordsByMonth = allrewords.stream().collect(Collectors.groupingBy(rewords->rewords.getDate().format(formatter),Collectors.summingInt(s-> Math.toIntExact(s.getRewordPoints()))));

            summery.setCustomerId(repo.findByCustomerId(customerId).get(0).getCustomerId());
            summery.setCustomerName(repo.findByCustomerId(customerId).get(0).getCustomerName());
            summery.setRewordPoints(RewordsByMonth);
            return summery;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static Long calculateRewordsPoints(Double amount) {
        long calculated_Reword_Points = 0;
        try {
            long tranzation_amount = Math.round(amount);
            if (tranzation_amount > 100) {
                calculated_Reword_Points += (tranzation_amount - 100) * 2 + (50 * 1);
            } else if (tranzation_amount > 50 && tranzation_amount < 100) {
                calculated_Reword_Points = (tranzation_amount - 50) * 1;
            } else {
                calculated_Reword_Points = 0;
            }

        }
        catch(Exception e){
             System.out.print(e);
        }

        return calculated_Reword_Points;
    }

}
