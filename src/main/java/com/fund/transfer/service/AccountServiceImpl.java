package com.fund.transfer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
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
		logger.info("Inside AccountServiceImpl of method getAllAccount ");
		List<Account> accounts = accountRepository.findByUserId(userId);
		if (accounts.isEmpty()) {
			logger.error(ApplicationConstant.INVALID_USER);
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
