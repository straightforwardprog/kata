package com.bank.demo.repository;

import com.bank.demo.model.AccountStatement;
import com.bank.demo.util.Statement;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository {
    public AccountStatement depositAccount(String statement, long idAccount, BigDecimal amount);
    public AccountStatement withdrawalAccount(String statement,long idAccount, BigDecimal amount);
    public AccountStatement withdrawalAllAccount(String statement,long idAccount);
    public List<AccountStatement> getHistory(long idAccount);
}
