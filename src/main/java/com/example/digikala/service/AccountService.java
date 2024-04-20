package com.example.digikala.service;

import com.example.digikala.dto.AccountDto;

import java.util.List;

public interface AccountService {

    void save(AccountDto accountDto) ;

    AccountDto getById(Long id);

    List<AccountDto> getAll() ;

    void update(Long id, AccountDto accountDto);

    void deleteById(Long id);

    void deleteAll();
}
