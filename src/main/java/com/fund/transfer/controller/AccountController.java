package com.fund.transfer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fund.transfer.constant.ApplicationConstant;
import com.fund.transfer.dto.AccountDetail;
import com.fund.transfer.dto.AccountResponseDto;
import com.fund.transfer.exception.NoAccountFoundException;
import com.fund.transfer.service.AccountService;

/**
 * 
 * @author Vinod B N
 * @version 1.0
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/users")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	AccountService accountService;

	/**
	 * 
	 * @param userId of User
	 * @return AccountResponseDto as response
	 * @exception NoAccountFoundException
	 * 
	 */
	@GetMapping("{userId}/accounts")
	public AccountResponseDto getAllAccount(@PathVariable Long userId) {
		logger.info(ApplicationConstant.INSIDE_ACCOUNT_CONTROLLER);
		List<AccountDetail> accDetails=accountService.getAllAccount(userId);
		AccountResponseDto accountResponseDto = new AccountResponseDto();
		accountResponseDto.setMessage(ApplicationConstant.SUCCESS);
		accountResponseDto.setStatusCode(HttpStatus.OK.value());
		accountResponseDto.setAcccountDetail(accDetails);
		return accountResponseDto;

	}

}
