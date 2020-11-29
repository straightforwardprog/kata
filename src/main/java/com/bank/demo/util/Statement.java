package com.bank.demo.util;

public enum  Statement {
    Deposit("Deposit"),Retrieve("Retrieve");
    private String name ;

    private Statement(String name) {
        this.name = name ;
    }

    public String getName() {
        return  this.name ;
    }
    }
