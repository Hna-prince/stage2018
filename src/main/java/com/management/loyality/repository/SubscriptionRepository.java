package com.management.loyality.repository;


import com.management.loyality.domain.Subscription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SubscriptionRepository  extends JpaRepository<Subscription, String> {
    @Query("select s from Subscription s  where s.idcompany = ?1  ")
    List<Subscription> findByCompany(String idCompany);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Subscription s set s.status = ?1 where s.idsubscription = ?2")
    void setStatusSubscription(int status, String idSubscription);

    @Query("select s from Subscription s  where s.id= ?1  and s.idcompany = ?2   ")
    List<Subscription> findByCustomerCompany(String idCustomer,String idCompany);

    @Query("select s from Subscription s  where s.id = ?1   ")
    List<Subscription> findByCustomer(String idCustomer,Pageable limit);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Subscription s set s.levels =s.levels- ?1 where s.idsubscription = ?2")
    void substractLevelSubscription(int levels, String idsubscription);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Subscription s set s.levels =s.levels+ ?1 where s.idsubscription = ?2")
    void addLevelSubscription(int levels, String idsubscription);




}
