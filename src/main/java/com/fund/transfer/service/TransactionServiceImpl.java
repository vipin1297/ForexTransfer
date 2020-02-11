package com.fund.transfer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fund.transfer.constant.ApplicationConstant;
import com.fund.transfer.dto.TransactionHistory;
import com.fund.transfer.dto.TransactionHistoryResponseDto;
import com.fund.transfer.entity.Transaction;
import com.fund.transfer.exception.NotFoundException;
import com.fund.transfer.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	public TransactionHistoryResponseDto getTransactionHistory(Long userId) throws NotFoundException {

		if (userId == 0 || userId == null) {
			log.error(ApplicationConstant.USERID_NOT_FOUND);
			throw new NotFoundException(ApplicationConstant.USERID_NOT_FOUND);

		}

		List<Transaction> transactionDetails = transactionRepository.findByUserId(userId);
		List<TransactionHistory> transactionHistory = new ArrayList();
		TransactionHistory transactionHistory2 = new TransactionHistory();
		for (Transaction t : transactionDetails) {
			transactionHistory2.setFromAccount(t.getFromAccount());
			transactionHistory2.setToAccount(t.getToAccount());
			transactionHistory2.setTransferredAmount(t.getTranferAmount());
			transactionHistory2.setTransactionDate(t.getTransactionDate());
			transactionHistory2.setTransactionStatus(t.getTransactionStatus());
		}

		transactionHistory.add(transactionHistory2);
		TransactionHistoryResponseDto transactionHistoryResponseDto = new TransactionHistoryResponseDto();
		transactionHistoryResponseDto.setTransactionDetails(transactionHistory);
		transactionHistoryResponseDto.setStatusCode(ApplicationConstant.SUCCESS_CODE);
		return transactionHistoryResponseDto;

	}

}
