package com.bank.demo.service;

import com.bank.demo.model.AccountStatement;
import com.bank.demo.util.Statement;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {
    public AccountStatement depoAccount(Statement statement,  long idAccount, double amount);
    public AccountStatement retreveAccount(Statement statement,long idAccount, double amount, boolean all);
    public List<AccountStatement> getHistory(long idAccount);

}
