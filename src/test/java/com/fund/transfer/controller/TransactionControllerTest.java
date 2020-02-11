package com.fund.transfer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.fund.transfer.dto.TransactionHistory;
import com.fund.transfer.dto.TransactionHistoryResponseDto;
import com.fund.transfer.entity.Transaction;
import com.fund.transfer.service.TransactionService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionControllerTest {

	@InjectMocks
	TransactionController transactionController;

	@Mock
	TransactionService transactionService;

	TransactionHistoryResponseDto transactionHistoryResponseDto;

	@Test
	public void getTransactionHistory() {
		TransactionHistoryResponseDto transResp= new TransactionHistoryResponseDto();
		List<TransactionHistory> transHistList= new ArrayList<>();
		TransactionHistory transHist= new TransactionHistory();
		transHist.setFromAccount(987654321L);
		transHist.setToAccount(12345678901L);
		transHist.setTransactionDate(LocalDateTime.now());
		transHist.setTransactionStatus("PENDING");
		transHist.setTransferredAmount(1000.00);
		transHistList.add(transHist);
		transResp.setStatusCode(200);
		transResp.setTransactionDetails(transHistList);

		Mockito.when(transactionService.getTransactionHistory(1L)).thenReturn(transResp);
		ResponseEntity<TransactionHistoryResponseDto> resp=transactionController.getTransactionHistory(1L);
	}

}
