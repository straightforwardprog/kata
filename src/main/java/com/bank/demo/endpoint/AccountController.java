package com.bank.demo.endpoint;

import com.bank.demo.model.AccountRequest;
import com.bank.demo.model.AccountStatement;
import com.bank.demo.service.AccountService;
import com.bank.demo.util.Statement;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Validated
public class AccountController {
    private AccountService accountService;

    /**
     * US 1
     * @param accountRequest
     * @return
     */
    @PostMapping("/deposit")
    public ResponseEntity<AccountStatement> depositAccount(@Valid @RequestBody AccountRequest accountRequest){
        return ResponseEntity.ok(accountService.depositAccount(Statement.Deposit,accountRequest.getIdAccount(),accountRequest.getAmount()));
    }

    /**
     *  US 2
     * @param accountRequest
     * @return
     */
    @PostMapping("/withdrawal")
    public ResponseEntity<AccountStatement> withdrawalAccount(@Valid @RequestBody AccountRequest accountRequest){
        return  ResponseEntity.ok(accountService.withdrawalAccount(Statement.Withdrawal,accountRequest.getIdAccount(),accountRequest.getAmount()));
    }
    /**
     *  US 2
     * @param accountRequest
     * @return
     */
    @PostMapping("/withdrawalALL")
    public ResponseEntity<AccountStatement> withdrawalALLAccount(@Valid @RequestBody AccountRequest accountRequest){
        return  ResponseEntity.ok(accountService.withdrawalALLAccount(Statement.Withdrawal,accountRequest.getIdAccount()));
    }

    /**
     * US 3
     * @param id
     * @return
     */
    @GetMapping("/history/{id}")
    public ResponseEntity<List<AccountStatement>> getHistory(@PathVariable(value = "id")long id){
        return  ResponseEntity.ok(accountService.getHistory(id));
    }
}
