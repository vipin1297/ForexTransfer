package com.fund.transfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fund.transfer.entity.Transaction;


@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Long>{


	List<Transaction> findAllByTransactionStatus(String pendingStatus);

	List<Transaction> findByUserId(Long userId);


}
