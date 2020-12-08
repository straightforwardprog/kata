package com.bank.demo.service;

import com.bank.demo.model.AccountStatement;
import com.bank.demo.util.Statement;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    public AccountStatement depositAccount(Statement statement,  long idAccount, BigDecimal amount);
    public AccountStatement withdrawalAccount(Statement statement,long idAccount, BigDecimal amount);
    public AccountStatement withdrawalALLAccount(Statement statement,long idAccount);
    public List<AccountStatement> getHistory(long idAccount);

}
