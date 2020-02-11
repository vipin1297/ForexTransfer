package com.fund.transfer.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionHistory {
	
	private Long fromAccount;
	private Long toAccount;
	private Double transferredAmount;
	private LocalDateTime transactionDate;
	private String transactionStatus;
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public Double getTransferredAmount() {
		return transferredAmount;
	}
	public void setTransferredAmount(Double transferredAmount) {
		this.transferredAmount = transferredAmount;
	}
	
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	

}
