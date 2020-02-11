package com.fund.transfer.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fund.transfer.constant.ApplicationConstant;
import com.fund.transfer.dto.LoginRequestDto;
import com.fund.transfer.dto.LoginResponseDto;
import com.fund.transfer.entity.User;
import com.fund.transfer.exception.NotFoundException;
import com.fund.transfer.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Raghib
 * 
 *         Login Service has the implementations for Login related api's.
 *         
 *
 */

@Service
@Slf4j

public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDto authenticateCustomer(LoginRequestDto loginRequestDto) throws NotFoundException {
		log.info("LoginServiceImpl authenticateCustomer ---> autheticating customer");
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		Optional<User> user = userRepository.findByUserIdAndPassword(loginRequestDto.getUserId(),
				loginRequestDto.getPassword());
		if (user.isPresent()) {

			BeanUtils.copyProperties(user.get(), loginResponseDto);
			loginResponseDto.setUserName(user.get().getUserName());
			loginResponseDto.setUserId(loginRequestDto.getUserId());
			loginResponseDto.setStatusCode(ApplicationConstant.SUCCESS_CODE);
			log.info("LoginServiceImpl authenticateCustomer ---> customer signed in");
			return loginResponseDto;
		} else {
			log.error("LoginServiceImpl authenticateCustomer ---> NotFoundException occured");
			throw new NotFoundException(ApplicationConstant.USER_NOT_FOUND);

		}

	}

}
