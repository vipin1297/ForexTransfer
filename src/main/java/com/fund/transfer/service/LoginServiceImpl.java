package com.fund.transfer.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fund.transfer.constant.ApplicationConstant;
import com.fund.transfer.dto.LoginRequestDto;
import com.fund.transfer.dto.LoginResponseDto;
import com.fund.transfer.entity.User;
import com.fund.transfer.exception.NotFoundException;
import com.fund.transfer.repository.UserRepository;

/**
 * 
 * @author Raghib
 * 
 *         Login Service has the implementations for Login related api's.
 *         
 *
 */

@Service


public class LoginServiceImpl implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	/*
	 * Method validate a particular user into application. 
	 * 
	 */
	@Override
	public LoginResponseDto authenticateCustomer(LoginRequestDto loginRequestDto) throws NotFoundException {
		logger.info("LoginServiceImpl authenticateCustomer ---> autheticating customer");
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		Optional<User> user = userRepository.findByUserNameAndPassword(loginRequestDto.getUserName(),
				loginRequestDto.getPassword());
		if (user.isPresent()) {

			BeanUtils.copyProperties(user.get(), loginResponseDto);
			loginResponseDto.setUserName(loginRequestDto.getUserName());
			loginResponseDto.setStatusCode(ApplicationConstant.SUCCESS_CODE);
			logger.info("LoginServiceImpl authenticateCustomer ---> customer signed in");
			return loginResponseDto;
		} else {
			logger.error("LoginServiceImpl authenticateCustomer ---> NotFoundException occured");
			throw new NotFoundException(ApplicationConstant.USER_NOT_FOUND);

		}

	}

}
