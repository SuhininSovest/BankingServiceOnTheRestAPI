package org.bank.BankingServiceOnTheRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long operationId;

    private long accountId;
    private long clientId;
    private short operationType;
    private Date operationDate;
    private double amount;
}
