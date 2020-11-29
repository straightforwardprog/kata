package com.bank.demo.model;

import lombok.Data;

@Data
public class AccountRequest {
    private long idAccount;
    private double amount;
    private boolean all;
}
