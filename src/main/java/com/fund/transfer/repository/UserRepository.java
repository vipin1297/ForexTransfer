package com.fund.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fund.transfer.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
