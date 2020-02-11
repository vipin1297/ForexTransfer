package com.fund.transfer.service;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fund.transfer.dto.AccountDetail;
import com.fund.transfer.entity.Account;
import com.fund.transfer.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceImplTest {
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@Mock
	AccountRepository accountRepository;
	
	@Test
	public void getAllAccount() {
		List<AccountDetail> list = new ArrayList<AccountDetail>();
		List<Account> account = null;
		Account account1 = new Account();
		AccountDetail accountDetail = new AccountDetail();
		accountDetail.setAccountNumber(1L);
		accountDetail.setAccountType("saving");
		accountDetail.setBalance(3000.0);
		accountDetail.setCurrency("INR");
		accountDetail.setUserId(1L);
		account1.setUserId(1L);
		account1.setAccountId(1L);
		account1.setAccountNumber(123L);
		account1.setAccountType("saving");
		account1.setBalance(3000.0);
		account1.setCurrency("INR");
		list.add(accountDetail);
		Mockito.when(accountRepository.findByUserId(account1.getUserId())).thenReturn(account);
		
		
	}

}
