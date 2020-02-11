package com.fund.transfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fund.transfer.dto.TransactionHistory;
import com.fund.transfer.entity.Transaction;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long>{


	List<Transaction> findAllByTransactionStatus(String pendingStatus);

	List<Transaction> findByUserId(Long userId);


}
