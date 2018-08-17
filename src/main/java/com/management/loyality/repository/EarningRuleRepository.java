package com.management.loyality.repository;

import com.management.loyality.domain.EarningRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EarningRuleRepository extends JpaRepository<EarningRule, String> {
    @Query("update EarningRule er set er.active = ?1 where er.idearningrule = ?2")
    void setActivity(int activity, String idEarningRule);

    @Query("select er from EarningRule er where er.idcompany = ?1")
    List<EarningRule> findByCompany(String idCompany);

    @Query("update EarningRule er set er.earnedpoint = :#{#oneEarnRule.earnedpoint}, er.active=:#{#oneEarnRule.active}, er.targetchar=:#{#oneEarnRule.targetchar} where er.idearningrule = :#{#oneEarnRule.idearningrule}")
    void setEarningRule(@Param("oneEarnRule")EarningRule oneEarnRule);


}
