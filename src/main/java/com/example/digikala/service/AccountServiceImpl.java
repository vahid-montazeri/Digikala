package com.example.digikala.service;

import com.example.digikala.dto.AccountDto;
import com.example.digikala.entity.Account;
import com.example.digikala.mapper.AccountMapper;
import com.example.digikala.repository.AccountRepository;
import com.example.digikala.util.ResourceBundleUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public void save(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        accountRepository.save(account);

    }

    @Override
    @Transactional
    public AccountDto getById(Long id) {
        Account accountEntity = accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ResourceBundleUtils.getExceptionMessage("account_not_found")
                ));
        return accountMapper.toDto(accountEntity);
    }

    @Override
    @Transactional
    public List<AccountDto> getAll() {
        List<Account> list = accountRepository.findAll();
        return accountMapper.toDtos(list);

    }

    @Override
    @Transactional
    public void update(Long id, AccountDto accountDto) {
        Account accountEntity = accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ResourceBundleUtils.getExceptionMessage("account_not_found")
                ));
        accountMapper.update(accountEntity, accountDto);
        accountRepository.save(accountEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        accountRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void deleteAll() {
        accountRepository.deleteAll();

    }
}
