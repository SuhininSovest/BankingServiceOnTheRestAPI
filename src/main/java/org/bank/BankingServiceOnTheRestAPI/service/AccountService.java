package org.bank.BankingServiceOnTheRestAPI.service;

import lombok.AllArgsConstructor;
import org.bank.BankingServiceOnTheRestAPI.dto.AccountDTO;
import org.bank.BankingServiceOnTheRestAPI.model.Account;
import org.bank.BankingServiceOnTheRestAPI.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final OperationListService operationListService;
    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    public Account createAccount(AccountDTO dto) {
        return accountRepository.save(Account.builder()
                .clientId(dto.getClientId())
                .balance(dto.getBalance())
                .build());
    }
    public List<Account> readAllAccounts() {
        return accountRepository.findAll();
    }
    public Optional<Account> readAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }
    public void updateAccountAll(Account account) {
        accountRepository.save(account);
    }
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
    public double getBalance(Long accountId) {
        return readAccountById(accountId).get().getBalance();
    }

    public String takeMoney(Long accountId, double howMuchTake) {
        var account = getAccount(accountId);
        short operationType = 209;
        if (howMuchTake <= 0 && getBalance(accountId) >= getBalance(accountId) - howMuchTake) {
            return "Insufficient funds or incorrect data, try again";
        } else {
            account.setBalance(getBalance(accountId) - howMuchTake);
            updateAccountAll(account);
            operationListService.createOperationList(accountId, operationType, howMuchTake);
            return "The operation was successful! Your balance is " + getBalance(accountId) + "$";
        }

    }

    public String putMoney(Long accountId, double howMuchPut) {
        var account = getAccount(accountId);
        short operationType = 309;
        if (howMuchPut <= 0 && getBalance(accountId) <= getBalance(accountId) + howMuchPut){
            return "Incorrect data, try again";
        }
        else {
            account.setBalance(getBalance(accountId) + howMuchPut);
            updateAccountAll(account);
            operationListService.createOperationList(accountId, operationType, howMuchPut);
            return "The operation was successful! Your balance is " + getBalance(accountId) + "$";
        }
    }
    public String transferMoney(Long fromAccountId, Long beforeAccountId, double howMuchPut) {
        short operationType = 609;
        if(readAccountById(fromAccountId).get().getBalance() < howMuchPut || howMuchPut <= 0) {
            return "Incorrect, try again";
        } else {
            takeMoney(fromAccountId, howMuchPut);
            putMoney(beforeAccountId, howMuchPut);
            operationListService.createOperationList(fromAccountId, operationType, howMuchPut);
            return "The transfer money was successful!";
        }
    }
}
