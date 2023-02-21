package com.kadir.AksoyBank.repository;

import com.kadir.AksoyBank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
