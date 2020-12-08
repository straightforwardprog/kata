package com.bank.demo.serviceImp;

import com.bank.demo.model.AccountStatement;
import com.bank.demo.repository.AccountRepository;
import com.bank.demo.service.AccountService;
import com.bank.demo.util.Statement;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountServiceImpTest {

    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountServiceImp accountService;

    @Test
    @Order(1)
    public void depositAccountTest() {
        AccountStatement expected=AccountStatement.builder().amount(new BigDecimal(10)).st(Statement.Deposit.name()).balance(new BigDecimal(10)).date(LocalDateTime.now()).build();
        when(accountRepository.depositAccount(eq(Statement.Deposit.name()), anyLong(), any(BigDecimal.class))).thenReturn(expected);
        AccountStatement st = accountService.depositAccount(Statement.Deposit, 1999999991L, new BigDecimal(10));
        assertEquals(expected, st);
        verify(accountRepository).depositAccount(eq(Statement.Deposit.name()), eq(1999999991L), eq(new BigDecimal(10)));

    }

    @Test
    @Order(2)
    public void withdrawalAccountTest() {

        AccountStatement expected = AccountStatement.builder().amount(new BigDecimal(6)).st(Statement.Withdrawal.name()).balance(new BigDecimal(4)).date(LocalDateTime.now()).build();
        when(accountRepository.withdrawalAccount(eq(Statement.Withdrawal.name()), anyLong(), any(BigDecimal.class))).thenReturn(expected);
        AccountStatement st = accountService.withdrawalAccount(Statement.Withdrawal, 1999999991L, new BigDecimal(6));
        assertEquals(expected, st);
        verify(accountRepository).withdrawalAccount(eq(Statement.Withdrawal.name()), eq(1999999991L), eq(new BigDecimal(6)));

    }

    @Test
    @Order(3)
    public void getHistoryTest() {
        List<AccountStatement> accountStatementList=new ArrayList<>();
        accountStatementList.add(new AccountStatement());
        accountStatementList.add(new AccountStatement());
        when(accountRepository.getHistory(anyLong())).thenReturn(accountStatementList);
        assertEquals(2, accountService.getHistory(1999999991L).size());
        verify(accountRepository).getHistory(anyLong());
    }


}