package com.fund.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fund.transfer.entity.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
