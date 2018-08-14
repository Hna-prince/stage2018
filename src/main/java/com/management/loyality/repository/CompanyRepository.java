package com.management.loyality.repository;

import com.management.loyality.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, String> {



    @Query("select c from Company c  order by c.idcompany desc  ")
    List<Company> companyList();
}
