package com.kadir.AksoyBank.repository;

import com.kadir.AksoyBank.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,String> {
}
