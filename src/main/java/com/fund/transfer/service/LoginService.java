package com.fund.transfer.service;

import com.fund.transfer.dto.LoginRequestDto;
import com.fund.transfer.dto.LoginResponseDto;
import com.fund.transfer.exception.NotFoundException;

public interface LoginService {

	public LoginResponseDto authenticateCustomer(LoginRequestDto loginRequestDto) throws NotFoundException;

}
