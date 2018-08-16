package com.management.loyality.repository;

import com.management.loyality.domain.Levels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LevelsRepository extends JpaRepository<Levels, String> {

    @Query("select l from Levels l  where l.idcompany= ?1  ")
    List<Levels> findByCompany(String idcompany);


}
