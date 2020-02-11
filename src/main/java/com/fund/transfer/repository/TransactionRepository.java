package com.fund.transfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fund.transfer.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{


	List<Transaction> findAllByTransactionStatus(String pendingStatus);

}
