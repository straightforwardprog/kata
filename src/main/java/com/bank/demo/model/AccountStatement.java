package com.bank.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountStatement {
    private String st;
    private LocalDateTime date;
    private BigDecimal amount;
    private BigDecimal balance=new BigDecimal(0);

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof AccountStatement)) {
            return false;
        }

        AccountStatement accountStatement = (AccountStatement) o;

        return accountStatement.getSt().equals(st)&& accountStatement.getAmount().equals(amount)&&accountStatement.getBalance().equals(balance);
    }

}
