package com.fund.transfer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fund.transfer.dto.TransactionHistoryResponseDto;
import com.fund.transfer.entity.Transaction;
import com.fund.transfer.repository.TransactionRepository;


@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionServiceTest {

	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;
	@Mock
	TransactionRepository transactionRepository;
	
	@Test
	public void testgetAllTransactions()
	{
		List<Transaction> list = new ArrayList<Transaction>();
		Transaction transaction1 = new Transaction();
		transaction1.setCalculatedAmount(1000.00);
		transaction1.setFromAccount(12345678901L);
		transaction1.setToAccount(12345678901L);
		transaction1.setTranferAmount(1000.00);
		transaction1.setUserId(1L);
		transaction1.setTransactionStatus("pending");
		Transaction transaction2 = new Transaction();
		transaction2.setCalculatedAmount(10000.00);
		transaction2.setFromAccount(12345678991L);
		transaction2.setToAccount(12345678900L);
		transaction2.setTranferAmount(10000.00);
		transaction2.setUserId(1L);
		transaction2.setTransactionStatus("pending");
		Transaction transaction3 = new Transaction();
		transaction3.setCalculatedAmount(100.00);
		transaction3.setFromAccount(12345678911881L);
		transaction3.setToAccount(1234567891201L);
		transaction3.setTranferAmount(10000.00);
		transaction3.setUserId(1L);
		transaction3.setTransactionStatus("pending");
		list.add(transaction1);
		list.add(transaction2);
		list.add(transaction3);
		
		Mockito.when(transactionRepository.findByUserId(1L)).thenReturn(list) ;
		TransactionHistoryResponseDto resp =  transactionServiceImpl.getTransactionHistory(1L);

		assertEquals(200,resp.getStatusCode() );
	}
}
