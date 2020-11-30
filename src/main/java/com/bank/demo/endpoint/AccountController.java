package com.bank.demo.endpoint;

import com.bank.demo.model.AccountRequest;
import com.bank.demo.model.AccountStatement;
import com.bank.demo.service.AccountService;
import com.bank.demo.util.Statement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    /**
     * US 1
     * @param accountRequest
     * @return
     */
    @PostMapping("/deposit")
    public AccountStatement depoAccount(@RequestBody AccountRequest accountRequest){
        return accountService.depoAccount(Statement.Deposit,accountRequest.getIdAccount(),accountRequest.getAmount());
    }

    /**
     *  US 2
     * @param accountRequest
     * @return
     */
    @PostMapping("/retrieve")
    public AccountStatement retreiveAccount(@RequestBody AccountRequest accountRequest){
        return accountService.retrieveAccount(Statement.Retrieve,accountRequest.getIdAccount(),accountRequest.getAmount(),accountRequest.isAll());
    }

    /**
     * US 3
     * @param id
     * @return
     */
    @GetMapping("/history/{id}")
    public List<AccountStatement> getHistory(@PathVariable(value = "id")long id){
        return accountService.getHistory(id);
    }
}
