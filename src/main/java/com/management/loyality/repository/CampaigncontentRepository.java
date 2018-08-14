package com.management.loyality.repository;

import com.management.loyality.domain.Campaigncontent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CampaigncontentRepository extends JpaRepository<Campaigncontent, String> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Campaigncontent c set c.title = :#{#oneCampaign.title}, c.bodies = :#{#oneCampaign.bodies}, c.idcampaigncontenttype= :#{#oneCampaign.idcampaigncontenttype} where c.idcampaigncontent = :#{#oneCampaign.idcampaigncontent}")
    void updateCampaignContent(@Param("oneCampaign")Campaigncontent oneCampaign);


    @Query("select c from Campaigncontent c  where c.idcompany = ?1  ")
    List<Campaigncontent> findByCompany(String idCompany);
}
