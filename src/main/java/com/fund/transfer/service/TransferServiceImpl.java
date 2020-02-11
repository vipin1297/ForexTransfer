package com.fund.transfer.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fund.transfer.constant.ApplicationConstant;
import com.fund.transfer.dto.ResponseDto;
import com.fund.transfer.dto.TransactionDto;
import com.fund.transfer.entity.Transaction;
import com.fund.transfer.repository.TransactionRepository;

@Service
public class TransferServiceImpl implements TransferService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public ResponseDto transfer(TransactionDto transactionDto, Long userId) {
		ResponseDto responseDto = new ResponseDto();
		Transaction transaction= new Transaction();
		transaction.setFromAccount(transactionDto.getFromAcc());
		transaction.setToAccount(transactionDto.getToAcc());
		transaction.setTranferAmount(transactionDto.getAmount());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactionStatus(ApplicationConstant.PENDING_STATUS);
		transaction.setUserId(userId);
		transactionRepository.save(transaction);
		responseDto.setStatusCode(ApplicationConstant.SUCCESS_CODE);
		
		return responseDto;
	}

}
