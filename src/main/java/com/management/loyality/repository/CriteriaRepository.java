package com.management.loyality.repository;

import com.management.loyality.domain.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CriteriaRepository extends JpaRepository<Criteria, String> {
    @Transactional
    @Modifying
    @Query("delete from Criteria l  where l.idsubscription= ?1 and l.idlevels= ?2 ")
   void deleteByIdcustomerAndIdlevels(String idsubscription, String idlevels);


    @Query("select c from Criteria c  where c.idsubscription= ?1  ")
    List<Criteria> findBySubscriber(String idsubscribtion);
}
