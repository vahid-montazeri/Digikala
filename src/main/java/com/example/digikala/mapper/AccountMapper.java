package com.example.digikala.mapper;

import com.example.digikala.dto.AccountDto;
import com.example.digikala.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountDto> {
}
