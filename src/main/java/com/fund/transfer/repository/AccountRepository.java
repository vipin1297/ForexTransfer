package com.fund.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fund.transfer.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
