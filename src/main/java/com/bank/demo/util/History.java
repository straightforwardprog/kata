package com.bank.demo.util;

import com.bank.demo.model.Account;
import com.bank.demo.model.AccountStatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class History {
    public static Map<Account, List<AccountStatement>> accountStatementList=new HashMap<Account, List<AccountStatement>>();
    static {
        accountStatementList.put(Account.builder().idAccount(1999999991L).build(),new ArrayList<AccountStatement>());
        accountStatementList.put(Account.builder().idAccount(1999999992L).build(),new ArrayList<AccountStatement>());
        accountStatementList.put(Account.builder().idAccount(1999999993L).build(),new ArrayList<AccountStatement>());
    }
}
