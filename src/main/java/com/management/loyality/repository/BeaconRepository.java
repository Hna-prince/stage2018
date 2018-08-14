package com.management.loyality.repository;

import com.management.loyality.domain.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BeaconRepository extends JpaRepository<Beacon, String> {
    @Query("select b from Beacon b  where b.idplace= ?1  ")
    List<Beacon> findByPlace(String idplace);

    @Modifying(clearAutomatically = true)
    @Transactional
    //@Query("update Beacon b set b.idplace = ?2, b.idcampaigncontent = ?3, b.tagname = ?4 , b.active =?5, b.titlenotification =?6, b.description= ?7, b.typebeacon = ?8 where  b.idbeacon = ?1")
    @Query("update Beacon b set b.idplace = :#{#oneBeacon.idplace}, b.idcampaigncontent = :#{#oneBeacon.idcampaigncontent}, b.tagname = :#{#oneBeacon.tagname} , b.active = :#{#oneBeacon.active}, b.titlenotification =:#{#oneBeacon.titlenotification}, b.description= :#{#oneBeacon.description}, b.typebeacon = :#{#oneBeacon.typebeacon} where  b.idbeacon = :#{#oneBeacon.idbeacon}")
   // void setBeaconFeatureById (String idBeacon, String idplace, String idCampaign, String tagName, int active, String titleNotification, String description, int typeBeacon);
    void setBeaconFeatureById (@Param("oneBeacon")Beacon oneBeacon );


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Beacon b set b.titlenotification = ?1, b.description = ?2 where b.idbeacon = ?3")
    void setBeaconNotificationById(String titleNotification, String description,String idBeacon);

    /*@Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Beacon b set b.active = ?1 where b.idbeacon = ?2 ")
    void activateBeacon(String active ,String idBeacon);
*/
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Beacon b set b.active = :#{#oneBeacon.active} where b.idbeacon = :#{#oneBeacon.idbeacon}  ")
    void activateBeacon(@Param("oneBeacon")Beacon oneBeacon);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Beacon b set b.idcampaigncontent = ?1 where b.idbeacon = ?2 ")
    void assignNewCampaign(String idCampaignContent, String idBeacon);

}
