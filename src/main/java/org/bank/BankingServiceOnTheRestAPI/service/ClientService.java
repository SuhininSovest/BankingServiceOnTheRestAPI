package org.bank.BankingServiceOnTheRestAPI.service;

import lombok.AllArgsConstructor;
import org.bank.BankingServiceOnTheRestAPI.dto.AccountDTO;
import org.bank.BankingServiceOnTheRestAPI.dto.ClientDTO;
import org.bank.BankingServiceOnTheRestAPI.model.Account;
import org.bank.BankingServiceOnTheRestAPI.model.Client;
import org.bank.BankingServiceOnTheRestAPI.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> readAllClients() {
        return clientRepository.findAll();
    }
    public Optional<Client> readClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }
    public void updateClientAll(Client client) {
        clientRepository.save(client);
    }
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
    public Client createClient(ClientDTO dto) {
        return clientRepository.save(Client.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build());
    }
}
