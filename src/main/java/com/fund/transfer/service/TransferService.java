package com.fund.transfer.service;

import com.fund.transfer.dto.ResponseDto;
import com.fund.transfer.dto.TransactionDto;

public interface TransferService {

	ResponseDto transfer(TransactionDto transactionDto, Long userId);

}
