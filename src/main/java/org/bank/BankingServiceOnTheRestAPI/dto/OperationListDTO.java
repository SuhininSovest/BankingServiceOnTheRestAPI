package org.bank.BankingServiceOnTheRestAPI.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OperationListDTO {
    private long accountId;
    private short operationType;
    private Date operationDate;
    private double amount;
}
