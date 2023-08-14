package org.bank.BankingServiceOnTheRestAPI.repository;

import org.bank.BankingServiceOnTheRestAPI.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
