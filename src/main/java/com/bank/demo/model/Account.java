package com.bank.demo.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class Account {
    private Long idAccount;
    private Client client;
    private List<AccountStatement> accountStatmentList;
    private double balance;

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Account)) {
            return false;
        }

        Account account = (Account) o;

        return account.idAccount.equals(idAccount);
    }



}
