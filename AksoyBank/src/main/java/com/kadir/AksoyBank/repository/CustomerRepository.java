package com.kadir.AksoyBank.repository;

import com.kadir.AksoyBank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> findByTcNo(String tcNo);


}
