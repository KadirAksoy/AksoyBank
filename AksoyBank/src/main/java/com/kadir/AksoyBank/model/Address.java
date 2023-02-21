package com.kadir.AksoyBank.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Address {
    public Address(String id, String city, String street) {
        this.id = id;
        this.city = city;
        this.street = street;
    }
    public Address(){

    }
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "address_id", updatable = false, nullable = false)
    private String id;
    @Column(name = "city")
    @NotNull
    private String city;
    @Column(name = "street")
    @NotNull
    private String street;



}
