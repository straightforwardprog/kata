package com.bank.demo;

import com.bank.demo.model.Account;
import com.bank.demo.model.AccountStatement;
import com.bank.demo.util.History;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class KataApplication {

    public static void main(String[] args) {
        SpringApplication.run(KataApplication.class, args);
    }

}
