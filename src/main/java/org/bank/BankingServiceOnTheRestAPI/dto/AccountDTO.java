package org.bank.BankingServiceOnTheRestAPI.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private Long clientId;
    private double balance;
}
