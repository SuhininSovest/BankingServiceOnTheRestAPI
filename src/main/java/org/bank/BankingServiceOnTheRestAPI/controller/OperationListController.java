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

    @GetMapping("/operationList/{accountId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public List<OperationList> getOperationListById(@PathVariable Long accountId) {
        return operationListService.getOperationListById(accountId);
    }

    @GetMapping("/account/{accountId}/operationList")
    public ResponseEntity<List<OperationList>> getOperationList(
            @PathVariable Long accountId,
            @RequestParam(name = "fromDate", required = false) String fromDate,
            @RequestParam(name = "beforeDate", required = false) String beforeDate)  {
        return new ResponseEntity<>(operationListService.getOperationList(accountId, fromDate, beforeDate), HttpStatus.OK);
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
