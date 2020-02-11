package com.fund.transfer.service;

import java.util.List;

import com.fund.transfer.dto.AccountDetail;

public interface AccountService {

	public List<AccountDetail> getAllAccount(Long userId);
}
