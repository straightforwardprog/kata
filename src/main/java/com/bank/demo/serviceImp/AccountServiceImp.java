package com.bank.demo.serviceImp;

import com.bank.demo.model.AccountStatement;
import com.bank.demo.repository.AccountRepository;
import com.bank.demo.service.AccountService;
import com.bank.demo.util.Statement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class AccountServiceImp implements AccountService {
    private AccountRepository accountRepository;

    @Override
    public AccountStatement depositAccount(Statement statement, long idAccount, BigDecimal amount) {
        return accountRepository.depositAccount(statement.name(),idAccount,amount);
    }

    @Override
    public AccountStatement withdrawalAccount(Statement statement, long idAccount, BigDecimal amount) {
        return accountRepository.withdrawalAccount(statement.name(),idAccount,amount);
    }

    @Override
    public AccountStatement withdrawalALLAccount(Statement statement, long idAccount) {
        return accountRepository.withdrawalAllAccount(statement.name(),idAccount);
    }

    @Override
    public List<AccountStatement> getHistory(long idAccount) {
        return accountRepository.getHistory(idAccount);
    }
}
