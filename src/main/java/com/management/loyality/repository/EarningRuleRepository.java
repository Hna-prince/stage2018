package com.management.loyality.repository;

import com.management.loyality.domain.Earningrule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EarningRuleRepository extends JpaRepository<Earningrule, String> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Earningrule er set er.active = ?1 where er.idearningrule = ?2")
    void setActivity(int activity, String idEarningRule);

    @Query("select er from Earningrule er where er.idcompany = ?1")
    List<Earningrule> findByCompany(String idCompany);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Earningrule er set er.earnedpoint = :#{#oneEarnRule.earnedpoint}, er.active=:#{#oneEarnRule.active}, er.targetchar=:#{#oneEarnRule.targetchar} where er.idearningrule = :#{#oneEarnRule.idearningrule}")
    void setEarningRule(@Param("oneEarnRule")Earningrule oneEarnRule);


}
