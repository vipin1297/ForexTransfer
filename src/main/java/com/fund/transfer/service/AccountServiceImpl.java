package com.fund.transfer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fund.transfer.constant.ApplicationConstant;
import com.fund.transfer.dto.AccountDetail;
import com.fund.transfer.entity.Account;
import com.fund.transfer.exception.NoAccountFoundException;
import com.fund.transfer.repository.AccountRepository;

/*
 * Method return all the account related information of a particular user. 
 * 
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	/**
	 * @author Vinod B N
	 * 
	 *         Method return all the account related information of a particular
	 *         user.
	 * 
	 * @param userId
	 * @return List of account
	 * @throws NoAccountFoundException
	 * 
	 */
	public List<AccountDetail> getAllAccount(Long userId) {
		List<Account> accounts = accountRepository.findByUserId(userId);
		if (accounts.isEmpty()) {
			throw new NoAccountFoundException(ApplicationConstant.INVALID_USER);
		}
		List<AccountDetail> accountdetails = new ArrayList<>();
		accounts.forEach(account -> {
			AccountDetail accountDetail = new AccountDetail();
			accountDetail.setAccountNumber(account.getAccountNumber());
			accountDetail.setAccountType(account.getAccountType());
			accountDetail.setBalance(account.getBalance());
			accountDetail.setCurrency(account.getCurrency());
			accountDetail.setUserId(account.getUserId());
			accountdetails.add(accountDetail);
		});
		return accountdetails;
	}

}
