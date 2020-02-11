package com.fund.transfer.dto;

import java.util.List;
import java.util.Optional;

import com.fund.transfer.entity.Transaction;



public class TransactionHistoryResponseDto {
	
	private Integer statusCode;
	private List<TransactionHistory> transactionDetails;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public List<TransactionHistory> getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(List<TransactionHistory> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	
	
	

}
