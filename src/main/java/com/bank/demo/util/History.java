package com.bank.demo.util;

import com.bank.demo.model.Account;
import com.bank.demo.model.AccountStatement;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for storing account operations
 */
@Component
public class History {

    public final Map<Long, Account> accountStatementList=new HashMap<Long, Account>();
     {
        accountStatementList.put(1999999991L,Account.builder().idAccount(1999999991L).balance(new BigDecimal(0)).accountStatmentList(new ArrayList<AccountStatement>()).build());
        accountStatementList.put(1999999992L,Account.builder().idAccount(1999999992L).balance(new BigDecimal(0)).accountStatmentList(new ArrayList<AccountStatement>()).build());
        accountStatementList.put(1999999992L,Account.builder().idAccount(1999999993L).balance(new BigDecimal(0)).accountStatmentList(new ArrayList<AccountStatement>()).build());
    }

}
