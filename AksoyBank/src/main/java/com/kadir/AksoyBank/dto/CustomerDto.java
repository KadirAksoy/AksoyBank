package com.kadir.AksoyBank.dto;


import com.kadir.AksoyBank.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
        private String id;
        private String tcNo;
        private String name;
        private String phoneNumber;
        private Address address;

}
