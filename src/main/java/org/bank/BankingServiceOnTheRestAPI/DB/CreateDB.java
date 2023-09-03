package org.bank.BankingServiceOnTheRestAPI.DB;

import org.bank.BankingServiceOnTheRestAPI.model.Account;
import org.bank.BankingServiceOnTheRestAPI.model.OperationList;

public class CreateDB {
    public void CreateAccount() {
        Account account = Account.builder().accountId(1).clientId(1).balance(999.99).build();
        Account account1 = Account.builder().accountId(2).clientId(2).balance(999.99).build();
        Account account2 = Account.builder().accountId(3).clientId(3).balance(999.99).build();
    }
}
