package com.bank.demo.serviceImp;

import com.bank.demo.model.Account;
import com.bank.demo.model.AccountStatement;
import com.bank.demo.service.AccountService;
import com.bank.demo.util.History;
import com.bank.demo.util.Statement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountServiceImp implements AccountService {
    AccountStatement accountStatement;
    @Override
    public AccountStatement depoAccount(Statement statement, long idAccount, double amount)  {
        Optional<Account> c=History.accountStatementList.keySet().stream().filter(a->a.getIdAccount()==idAccount).findFirst();
        c.ifPresent(account ->{
            accountStatement= AccountStatement.builder().amount(amount).date(LocalDateTime.now()).balance(account.getBalance()+amount).st(statement.getName()).build();
            History.accountStatementList.get(account).add(accountStatement);
        });

        return accountStatement;
    }

    @Override
    public AccountStatement retreveAccount(Statement statement, long idAccount, double amount, boolean all) {
        Optional<Account> c=History.accountStatementList.keySet().stream().filter(a->a.getIdAccount()==idAccount).findFirst();
        if (all){
            c.ifPresent(account ->{
                accountStatement= AccountStatement.builder().amount(account.getBalance()).date(LocalDateTime.now()).balance(0).st(statement.getName()).build();
                History.accountStatementList.get(account).add(accountStatement);
            });
        }else{
            c.ifPresent(account ->{
                accountStatement= AccountStatement.builder().amount(amount).date(LocalDateTime.now()).balance(account.getBalance()-amount).st(statement.getName()).build();
                History.accountStatementList.get(account).add(accountStatement);
            });
        }


        return accountStatement;
    }

    @Override
    public List<AccountStatement> getHistory(long idAccount) {
        Optional<Account> c=History.accountStatementList.keySet().stream().filter(a->a.getIdAccount()==idAccount).findFirst();
        return History.accountStatementList.get(c.get());
    }
}
