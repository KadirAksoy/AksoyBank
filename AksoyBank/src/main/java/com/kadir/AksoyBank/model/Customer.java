package com.kadir.AksoyBank.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Customer {

    public Customer(String id, String tcNo, String name, String phoneNumber, Address address) {
        this.id = id;
        this.tcNo = tcNo;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public Customer(){

    }


    @Id
    @Column(name = "id")
    @NotNull
    private String id;
    @Column(name = "tcNo")
    @NotNull
    private String tcNo;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;



}

