package com.management.loyality.repository;

import com.management.loyality.domain.Adminst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminstRepository extends JpaRepository<Adminst, String> {


    @Query("select a from Adminst a  where a.email = ?1 or a.password = ?2 ")
    List<Adminst> findAdminByEmailPassword(String email, String password);
}