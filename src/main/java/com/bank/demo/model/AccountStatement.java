package com.bank.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountStatement {
    private String st;
    private LocalDateTime date;
    private double amount;
    private double balance;



}
