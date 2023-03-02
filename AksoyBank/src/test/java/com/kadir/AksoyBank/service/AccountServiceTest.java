package com.kadir.AksoyBank.service;

import com.kadir.AksoyBank.dto.AccountDto;
import com.kadir.AksoyBank.dto.convert.AccountDtoConverter;
import com.kadir.AksoyBank.model.Account;
import com.kadir.AksoyBank.model.Address;
import com.kadir.AksoyBank.model.Customer;
import com.kadir.AksoyBank.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;


class AccountServiceTest {

    private AccountService accountService;

    private AccountRepository accountRepository;
    private AccountDtoConverter accountDtoConverter;
    private CustomerService customerService;

    @BeforeEach
    public void setUp() throws Exception{
        accountRepository = Mockito.mock(AccountRepository.class);
        accountDtoConverter = Mockito.mock(AccountDtoConverter.class);
        customerService = Mockito.mock(CustomerService.class);

        accountService = new AccountService(accountRepository,
                accountDtoConverter,
                customerService);
    }

    @Test
    void whenCreateAccountCalledWithValidRequest_itShouldReturnValidAccountDto() {
        AccountDto createAccountDto = generateCreateAccountDto();
        Customer customer = generateCustomer();
        Account account = generateAccount(createAccountDto);
        AccountDto accountDto = generateAccountDto();

        Mockito.when(customerService.getCustomerById("123")).thenReturn(customer);
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        Mockito.when(accountDtoConverter.convert(account)).thenReturn(accountDto);

        AccountDto result = accountService.createAccount(createAccountDto);

        Assertions.assertEquals(result, accountDto);
        Mockito.verify(customerService).getCustomerById("123");
        Mockito.verify(accountRepository).save(account);
        Mockito.verify(accountDtoConverter).convert(account);



    }

//    @Test
//    void updateAccount() {
//    }
//
//    @Test
//    void deleteAccount() {
//    }
//
//    @Test
//    void getAllAccount() {
//    }
//
//    @Test
//    void getAccountById() {
//    }
//
//    @Test
//    void withdrawMoney() {
//    }
//
//    @Test
//    void addMoney() {
//    }


      private AccountDto generateCreateAccountDto(){
        AccountDto accountDto = new AccountDto("1234",
                "12345",
                100.00);
        return  accountDto;
      }
    private Customer generateCustomer(){
        return Customer.builder()
                .id("123")
                .name("kadir")
                .tcNo("123456789")
                .phoneNumber("987654321")
                .address(Address.builder().id("12345").city("istanbul").street("zb").build())
                .build();
    }
    private Account generateAccount(AccountDto accountDto){
        return Account.builder()
                .id(accountDto.getId())
                .customerId(accountDto.getCustomerId())
                .balance(accountDto.getBalance())
                .build();
    }
    private AccountDto generateAccountDto(){
        return AccountDto.builder()
                .id("1234")
                .customerId("12345")
                .balance(100.00)
                .build();
    }

}