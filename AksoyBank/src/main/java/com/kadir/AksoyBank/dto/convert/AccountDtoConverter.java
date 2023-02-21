package com.kadir.AksoyBank.dto.convert;

import com.kadir.AksoyBank.dto.AccountDto;
import com.kadir.AksoyBank.model.Account;
import org.springframework.stereotype.Component;


@Component
public class AccountDtoConverter {

    public AccountDto convert(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .customerId(account.getCustomerId())
                .balance(account.getBalance())
                .build();
    }
}
