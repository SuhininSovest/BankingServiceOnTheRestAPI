package org.bank.BankingServiceOnTheRestAPI.service;

import lombok.AllArgsConstructor;
import org.bank.BankingServiceOnTheRestAPI.dto.OperationListDTO;
import org.bank.BankingServiceOnTheRestAPI.model.OperationList;
import org.bank.BankingServiceOnTheRestAPI.repository.OperationListRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OperationListService {

    private final OperationListRepository operationListRepository;

    public OperationList getOperationId(Long operationId) {
        return operationListRepository.findById(operationId).orElse(null);
    }
    //Output of the entire OperationList (For analysts and employees)
    public List<OperationList> findAll() {
        return operationListRepository.findAll();
    }
    // create
    public OperationList createOperationList(OperationListDTO dto) {
        return operationListRepository.save(OperationList.builder()
                .accountId(dto.getAccountId())
                .operationType(dto.getOperationType())
                .operationDate(new Date())
                .amount(dto.getAmount())
                .build());
    }
    public OperationList createOperationList(long accountId, short operationType, double amount) {
        return operationListRepository.save(OperationList.builder()
                .accountId(accountId)
                .operationType(operationType)
                .operationDate(new Date())
                .amount(amount)
                .build());
    }
    public void deleteOperation(Long operationId){
        operationListRepository.deleteById(operationId);
    }
    //AllArg. Output a list of operations for a certain period of time, you can send a date in the format dd/MM/yyyy to start
    //http://localhost:8090/account/1/operationList?fromDate=04/09/2023&beforeDate=06/09/2023
    public List<OperationList> getOperationList(Long accountId, String fromDate, String beforeDate) {
        List<OperationList> operationLists = findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return operationLists.stream()
                .filter(operationList -> operationList.getAccountId() == accountId)
                .filter(operationList -> {
                    try {
                        return (fromDate == null || operationList.getOperationDate().compareTo(dateFormat.parse(fromDate)) >= 0)
                                && (beforeDate == null || operationList.getOperationDate().compareTo(dateFormat.parse(beforeDate)) <= 0);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
    //NoDate. Displaying a list of operations for a specific account
    public List<OperationList> getOperationListById(Long accountId) {
        List<OperationList> operationLists = findAll();
        return operationLists.stream()
                .filter(operationList -> operationList.getAccountId() == accountId)
                .collect(Collectors.toList());
    }
}
