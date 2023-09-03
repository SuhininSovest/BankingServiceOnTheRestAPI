package org.bank.BankingServiceOnTheRestAPI.repository;

import org.bank.BankingServiceOnTheRestAPI.model.OperationList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OperationListRepository extends JpaRepository<OperationList, Long> {
}
