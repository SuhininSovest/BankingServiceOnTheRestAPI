package org.bank.BankingServiceOnTheRestAPI.controller;

import lombok.AllArgsConstructor;
import org.bank.BankingServiceOnTheRestAPI.dto.AccountDTO;
import org.bank.BankingServiceOnTheRestAPI.model.Account;
import org.bank.BankingServiceOnTheRestAPI.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/")
    public String homePageAccount() {
        return "<html><body>"
                + "<h1>WELCOME to Account</h1>"
                + "</body></html>";
    }
    @PostMapping("/create")
    public ResponseEntity<Account> create(@RequestBody AccountDTO dto) {
        return new ResponseEntity<>(accountService.createAccount(dto), HttpStatus.CREATED);
    }
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> readAll() {
        return new ResponseEntity<>(accountService.readAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/accounts/{accountId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Optional<Account> readById(@PathVariable Long accountId) {
        return accountService.readAccountById(accountId);
    }

    @PutMapping("/update/account/{accountId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void update(@RequestBody Account account) {
        accountService.updateAccountAll(account);
    }
    @DeleteMapping("/delete/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
    }

    @GetMapping("/getBalance/{accountId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String getBalanceById(@PathVariable Long accountId) {
        return "Your balance is equal to " + accountService.getBalance(accountId) + "$";
    }

    @PutMapping("/takeMoney/{accountId}/{howMuchTake}")
    public String takeMoneyById(@PathVariable Long accountId, @PathVariable double howMuchTake) {
        return accountService.takeMoney(accountId, howMuchTake);
    }

    @PutMapping("/putMoney/{accountId}/{howMuchPut}")
    public String putMoneyById(@PathVariable Long accountId, @PathVariable double howMuchPut) {
        return accountService.putMoney(accountId, howMuchPut);
    }
    @PutMapping("/transferMoney/{fromAccountId}/{beforeAccountId}/{howMuchPut}")
    public String transferMoney(@PathVariable Long fromAccountId, @PathVariable Long beforeAccountId, @PathVariable double howMuchPut){
        return accountService.transferMoney(fromAccountId, beforeAccountId, howMuchPut);
    }
}
