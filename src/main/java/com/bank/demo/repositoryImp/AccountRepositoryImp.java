package com.bank.demo.repositoryImp;

import com.bank.demo.model.Account;
import com.bank.demo.model.AccountStatement;
import com.bank.demo.repository.AccountRepository;
import com.bank.demo.util.History;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class AccountRepositoryImp implements AccountRepository {
    private AccountStatement accountStatement;
    private History history;

    @Override
    public AccountStatement depositAccount(String statement, long idAccount, BigDecimal amount) {
        Account account = history.accountStatementList.get(idAccount);
        account.setBalance(account.getBalance().add(amount));
        accountStatement = AccountStatement.builder().amount(amount).date(LocalDateTime.now()).balance(account.getBalance()).st(statement).build();
        account.getAccountStatmentList().add(accountStatement);
        return accountStatement;
    }

    @Override
    public AccountStatement withdrawalAccount(String statement, long idAccount, BigDecimal amount) {
        Account account = history.accountStatementList.get(idAccount);
        account.setBalance(account.getBalance().subtract(amount));
        accountStatement = AccountStatement.builder().amount(amount).date(LocalDateTime.now()).balance(account.getBalance()).st(statement).build();
        account.getAccountStatmentList().add(accountStatement);
        return accountStatement;
    }

    @Override
    public AccountStatement withdrawalAllAccount(String statement, long idAccount) {
        Account account = history.accountStatementList.get(idAccount);
        accountStatement = AccountStatement.builder().amount(account.getBalance()).date(LocalDateTime.now()).balance(BigDecimal.valueOf(0)).st(statement).build();
        account.getAccountStatmentList().add(accountStatement);
        account.setBalance(BigDecimal.valueOf(0));
        return accountStatement;
    }

    @Override
    public List<AccountStatement> getHistory(long idAccount) {
        return history.accountStatementList.get(idAccount).getAccountStatmentList();
    }
}
