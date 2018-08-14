package com.management.loyality.repository;

import com.management.loyality.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsersRepository extends JpaRepository<Users, String> {

}
