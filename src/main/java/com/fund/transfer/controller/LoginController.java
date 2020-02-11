package com.fund.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fund.transfer.dto.LoginRequestDto;
import com.fund.transfer.dto.LoginResponseDto;
import com.fund.transfer.exception.NotFoundException;
import com.fund.transfer.service.LoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * This Controller is having the Login related functionalities. This
 * Controller will call the loginService in which the implementations are
 * done.
 * 
 * @API It has a method which will authenticate the User.
 * @author Raghib
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

	/**
	 * This will inject all the implementations in the loginService.
	 */
	@Autowired
	LoginService loginService;

	/**
	 * @author Raghib
	 * 
	 *         this API is used to authenticate the User
	 * 
	 * @param from userId,Password.
	 * @return statusCode,userName,userId.
	 * @throws NotFoundException
	 * 
	 */
	
	@PostMapping
	public ResponseEntity<LoginResponseDto> authenticateCustomer(@RequestBody LoginRequestDto loginRequestDto)
			throws NotFoundException {

		return ResponseEntity.ok().body(loginService.authenticateCustomer(loginRequestDto));
	}

}
