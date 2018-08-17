package com.management.loyality.repository;

import com.management.loyality.domain.Loyalitypoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoyalitypointRepository extends JpaRepository<Loyalitypoint, String> {
    @Query("select lp from Loyalitypoint lp where lp.idsubscription = ?1")
    List<Loyalitypoint> findBySubscriber(String idsubscription);
}
