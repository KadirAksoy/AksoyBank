package com.kadir.AksoyBank.service;

import com.kadir.AksoyBank.dto.CustomerDto;
import com.kadir.AksoyBank.dto.convert.CustomerDtoConverter;
import com.kadir.AksoyBank.exception.CustomerNotFoundException;
import com.kadir.AksoyBank.model.Customer;
import com.kadir.AksoyBank.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    public CustomerDto createCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setTcNo(customerDto.getTcNo());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddress(customerDto.getAddress());

        customerRepository.save(customer);

        return customerDtoConverter.convert(customer);
    }

    public List<CustomerDto> getAllCustomer(){
        List<Customer> customerList = customerRepository.findAll();

        List<CustomerDto> customerDtoList = new ArrayList<>();    // can be increased in size.

        for (Customer customer:customerList){
            customerDtoList.add(customerDtoConverter.convert(customer));
        }
        return customerDtoList;
    }

    public CustomerDto updateCustomer(String id,CustomerDto customerDto){
        Optional<Customer> customerOptional = customerRepository.findById(id);

        customerOptional.ifPresent(customer -> {
            customer.setName(customerDto.getName());
            customer.setTcNo(customerDto.getTcNo());
            customer.setPhoneNumber(customerDto.getPhoneNumber());
            customer.setAddress(customerDto.getAddress());
            customerRepository.save(customer);
        });

        return customerOptional.map(customerDtoConverter::convert).orElse(new CustomerDto());
    }

    public void deleteCustomer(String id){
        customerRepository.deleteById(id);
    }

    public CustomerDto getCustomerDtoById(String id){

        Optional<Customer> customerOptional = customerRepository.findById(id);

        return customerOptional.map(customerDtoConverter::convert).orElse(new CustomerDto());

    }
    protected Customer getCustomerById(String id){
        return customerRepository.findById(id).orElse(new Customer());
    }

    public CustomerDto getCustomerByTcNo(String tcNo){
            Optional<Customer> customerOptional = customerRepository.findByTcNo(tcNo);

            return customerOptional.map(customerDtoConverter::convert).orElse(new CustomerDto());
    }

}
