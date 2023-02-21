package com.kadir.AksoyBank.dto.convert;

import com.kadir.AksoyBank.dto.CustomerDto;
import com.kadir.AksoyBank.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public CustomerDto convert(Customer customer){

        CustomerDto newCustomer = new CustomerDto();
        newCustomer.setId(customer.getId());
        newCustomer.setTcNo(customer.getTcNo());
        newCustomer.setName(customer.getName());
        newCustomer.setPhoneNumber(customer.getPhoneNumber());
        newCustomer.setAddress(customer.getAddress());

        return newCustomer;



    }



}
