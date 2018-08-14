package com.management.loyality.repository;

import com.management.loyality.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("select c from Customer c  where c.email = ?1 or c.password = ?2 ")
    List<Customer> findByEmailPassword(String email, String password);
}
