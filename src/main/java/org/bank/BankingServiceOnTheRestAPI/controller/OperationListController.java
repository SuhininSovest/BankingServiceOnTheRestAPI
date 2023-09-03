package org.bank.BankingServiceOnTheRestAPI.controller;

import lombok.AllArgsConstructor;
import org.bank.BankingServiceOnTheRestAPI.dto.OperationListDTO;
import org.bank.BankingServiceOnTheRestAPI.model.OperationList;
import org.bank.BankingServiceOnTheRestAPI.service.OperationListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class OperationListController {

    private final OperationListService operationListService;

    @DeleteMapping("/delete/operationId/{operationId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long operationId) {
        operationListService.deleteOperation(operationId);
    }
    //Output a list of operations for a certain period of time, you can send a date in the format dd/MM/yyyy to start
    @GetMapping("/account/{accountId}/operationList/{fromDate}/{beforeDate}")
    public ResponseEntity<List<OperationList>> readOperationListWithDate(@PathVariable Long accountId, @PathVariable String fromDate, @PathVariable String beforeDate) {
        return (ResponseEntity<List<OperationList>>) operationListService.getOperationList(operationListService.findAll(), accountId, fromDate, beforeDate);
    }
    //Displaying a list of operations for a specific account
    @GetMapping("/account/{accountId}/operationList")
    public ResponseEntity<List<OperationList>> getOperationListById(@PathVariable Long accountId) {
        return (ResponseEntity<List<OperationList>>) operationListService.getOperationListById(operationListService.findAll(), accountId);
    }
    @GetMapping("/operationAll")
    public ResponseEntity<List<OperationList>> readAll() {
        return new ResponseEntity<>(operationListService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/createOPlistTest")
    public ResponseEntity<OperationList> create(@RequestBody OperationListDTO dto) {
        return new ResponseEntity<>(operationListService.createOperationList(dto), HttpStatus.OK);
    }
    @GetMapping("/operation/{operationId}")
    public Optional<OperationList> readById(@PathVariable Long operationId) {
        return Optional.ofNullable(operationListService.getOperationId(operationId));
    }

}
