package com.fund.transfer.service;


import static org.junit.Assert.assertNotNull;
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
		List<Account> accounts = new ArrayList<Account>();
		List<AccountDetail> accountDetails = new ArrayList<>();
		Account account = new Account();
		AccountDetail accountDetail = new AccountDetail();
		account.setAccountId(1L);
		account.setAccountNumber(1234L);
		account.setAccountType("saving");
		account.setBalance(3000.0);
		account.setCurrency("INR");
		account.setUserId(1L);
		accounts.add(account);
		accountDetail.setAccountNumber(1234L);
		accountDetail.setAccountType("saving");
		accountDetail.setBalance(3000.0);
		accountDetail.setCurrency("INR");
		accountDetail.setUserId(1L);
		accountDetails.add(accountDetail);
		Mockito.when(accountRepository.findByUserId(1L)).thenReturn(accounts);
		accountDetails = accountServiceImpl.getAllAccount(1L);
		assertEquals(1, accountDetails.size());
		
	}

}
