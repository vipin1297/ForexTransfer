package com.fund.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fund.transfer.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
