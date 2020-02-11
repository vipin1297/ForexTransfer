package com.fund.transfer.service;


import com.fund.transfer.dto.TransactionHistoryResponseDto;
import com.fund.transfer.exception.NotFoundException;

public interface TransactionService {

	TransactionHistoryResponseDto getTransactionHistory(Long userId)throws NotFoundException;
	
	

}
