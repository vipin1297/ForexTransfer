package com.fund.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fund.transfer.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
