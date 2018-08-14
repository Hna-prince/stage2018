package com.management.loyality.repository;

import com.management.loyality.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, String> {

    @Query("select p from Place p  where p.idAdmin= ?1  ")
    List<Place> findByAdmin(String idAdmin);

    @Modifying(clearAutomatically = true)
     @Transactional
    @Query("update Place p set p.address = ?1, p.nameplace = ?2 where p.idplace = ?3")
    void setPlaceInfoById(String address, String nameplace, String idplace);
}
