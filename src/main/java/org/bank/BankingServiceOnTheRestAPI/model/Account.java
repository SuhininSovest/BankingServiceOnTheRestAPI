package org.bank.BankingServiceOnTheRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long accountId;
    private long clientId;
    private double balance;
    @OneToMany
    @JoinColumn(name = "accountId")
    private List<OperationList> operationList;

}
