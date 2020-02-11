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
		AccountDetail accountDetail = new AccountDetail();
		accountDetail.setAccountNumber(1L);
		accountDetail.setAccountType("saving");
		accountDetail.setBalance(3000.0);
		accountDetail.setCurrency("INR");
		accountDetail.setUserId(1L);
		list.add(accountDetail);
		Mockito.when(accountRepository.findByUserId(accountDetail.getUserId())).thenReturn(account);
		List<AccountDetail> db = accountServiceImpl.getAllAccount(1L);
		assertNotNull(db);;
		assertTrue(db.equals(account));
		
	}

}
