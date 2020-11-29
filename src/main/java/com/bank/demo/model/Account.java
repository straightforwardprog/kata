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



}
