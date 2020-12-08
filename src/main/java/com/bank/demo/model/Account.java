package com.bank.demo.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Data
@Builder
public class Account {
    private Long idAccount;
    private Client client;
    private List<AccountStatement> accountStatmentList;
    private BigDecimal balance;

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Account)) {
            return false;
        }

        Account account = (Account) o;

        return account.idAccount.equals(idAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount);
    }
}
