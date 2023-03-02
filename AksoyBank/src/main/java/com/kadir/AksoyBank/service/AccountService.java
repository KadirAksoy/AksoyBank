package com.kadir.AksoyBank.service;

import com.kadir.AksoyBank.dto.AccountDto;
import com.kadir.AksoyBank.dto.convert.AccountDtoConverter;
import com.kadir.AksoyBank.exception.CustomerNotFoundException;
import com.kadir.AksoyBank.model.Account;
import com.kadir.AksoyBank.model.Customer;
import com.kadir.AksoyBank.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountDtoConverter accountDtoConverter;
    private final CustomerService customerService;

    public AccountService(AccountRepository accountRepository,
                          AccountDtoConverter accountDtoConverter,
                          CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.accountDtoConverter = accountDtoConverter;
        this.customerService = customerService;
    }

    public AccountDto createAccount(AccountDto accountDto){
        Customer customer = customerService.getCustomerById(accountDto.getCustomerId());

        if (customer.getId() == null){
            throw new CustomerNotFoundException("Customer not found");
        }
        Account account = Account.builder()
                .id(accountDto.getId())
                .customerId(accountDto.getCustomerId())
                .balance(accountDto.getBalance())
                .build();

        accountRepository.save(account);

        return accountDtoConverter.convert(accountRepository.save(account));
    }
    public AccountDto updateAccount(String id , AccountDto accountDto){
        Customer customer = customerService.getCustomerById(accountDto.getCustomerId());

        if (customer.getId() == null) {
            return AccountDto.builder().build();
        }
        Optional<Account> accountOptional = accountRepository.findById(id);
        accountOptional.ifPresent(account -> {
            account.setBalance(accountDto.getBalance());
            account.setCustomerId(accountDto.getCustomerId());
            accountRepository.save(account);
        });
        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());


    }
    public void deleteAccount(String id){
        accountRepository.deleteById(id);
    }

    public List<AccountDto> getAllAccount(){
        List<Account> accountList = accountRepository.findAll();

        List<AccountDto> accountDtoList = new ArrayList<>();

        for (Account account:accountList){
            accountDtoList.add(accountDtoConverter.convert(account));
        }
        return accountDtoList;
    }
    public AccountDto getAccountById(String id){
        Optional<Account> accountOptional =  accountRepository.findById(id);

        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }
    public AccountDto withdrawMoney(String id, double amount){
        Optional<Account> accountOptional = accountRepository.findById(id);

        accountOptional.ifPresent(account -> {
            if (account.getBalance() > amount){
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);
            }else {
                System.out.println("Insufficient funds your account id :"+id+"your balance :"+account.getBalance());
            }
        });
        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }
    public AccountDto addMoney(String id, double amount){
        Optional<Account> accountOptional = accountRepository.findById(id);

        accountOptional.ifPresent(account -> {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        });

        return accountOptional.map(accountDtoConverter::convert).orElse(new AccountDto());
    }








    //public void transferMoney(){}
}
