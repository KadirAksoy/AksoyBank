package com.kadir.AksoyBank.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Account {
    public Account(String id, String customerId, Double balance) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
    }

    public Account() {
    }

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "balance")
    private Double balance;

}
