package com.example.digikala.controller;

import com.example.digikala.dto.AccountDto;
import com.example.digikala.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
@AllArgsConstructor

public class AccountController {
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Void> creat(@RequestBody AccountDto accountDto) {
        accountService.save(accountDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<AccountDto> getById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getById(id);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll( ) {
        List<AccountDto> accountServiceAll = accountService.getAll();
        return new ResponseEntity<>(accountServiceAll, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody AccountDto accountDto) {
        accountService.update(id, accountDto);
        return ResponseEntity.ok("Account With id" + id + "Update Successfully");
    }


    @DeleteMapping
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        accountService.deleteById(id);
        return ResponseEntity.ok("Account With id" + id + "Deleted Successfully");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAll(@PathVariable Long id) {
        accountService.deleteAll();
        return ResponseEntity.ok(null);
    }

}






