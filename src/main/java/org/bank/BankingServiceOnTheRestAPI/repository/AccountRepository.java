package org.bank.BankingServiceOnTheRestAPI.repository;

import org.bank.BankingServiceOnTheRestAPI.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
