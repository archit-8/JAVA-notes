package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.InsufficientAmountException;
import com.example.demo.exception.InvalidAccountException;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

import java.math.BigDecimal;

@Service
public class BankService {

    private final AccountRepository accountRepo;

    public BankService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Transactional
    public Account createAccount(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Account name is required");
        }
        Account acc = new Account();
        acc.setName(name);
        acc.setBalance(0L);
        return accountRepo.save(acc);
    }

    @Transactional
    public void deposit(Long accNo, Long amount) {
        if (amount==0) {
            throw new IllegalArgumentException("Invalid amount: must be > 0");
        }

        Account acc = accountRepo.findById(accNo)
                .orElseThrow(() -> new InvalidAccountException("Account not found: " + accNo));

        acc.setBalance(acc.getBalance()+amount);
        accountRepo.save(acc);
    }

    @Transactional
    public void withdraw(Long accNo, Long amount) {
        if (amount== 0) {
            throw new IllegalArgumentException("Invalid amount: must be > 0");
        }

        Account acc = accountRepo.findById(accNo)
                .orElseThrow(() -> new InvalidAccountException("Account not found: " + accNo));

        if (amount.compareTo(acc.getBalance()) > 0) {
            throw new InsufficientAmountException("Insufficient balance");
        }

        acc.setBalance(acc.getBalance()-amount);
        accountRepo.save(acc);
    }

    @Transactional
    public Account getAccountByAccNo(Long accNo) {
        return accountRepo.findById(accNo)
                .orElseThrow(() -> new InvalidAccountException("Account not found: " + accNo));
    }
}
