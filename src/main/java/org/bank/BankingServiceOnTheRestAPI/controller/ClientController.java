package org.bank.BankingServiceOnTheRestAPI.controller;

import lombok.AllArgsConstructor;
import org.bank.BankingServiceOnTheRestAPI.dto.AccountDTO;
import org.bank.BankingServiceOnTheRestAPI.dto.ClientDTO;
import org.bank.BankingServiceOnTheRestAPI.model.Account;
import org.bank.BankingServiceOnTheRestAPI.model.Client;
import org.bank.BankingServiceOnTheRestAPI.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping("/create/client")
    public ResponseEntity<Client> create(@RequestBody ClientDTO dto) {
        return new ResponseEntity<>(clientService.createClient(dto), HttpStatus.CREATED);
    }
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> readAll() {
        return new ResponseEntity<>(clientService.readAllClients(), HttpStatus.OK);
    }

    @GetMapping("/clients/{clientId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Optional<Client> readById(@PathVariable Long clientId) {
        return clientService.readClientById(clientId);
    }
    @PutMapping("/update/client/{clientId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void update(@RequestBody Client client) {
        clientService.updateClientAll(client);
    }

    @DeleteMapping("/delete/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
    }
}
