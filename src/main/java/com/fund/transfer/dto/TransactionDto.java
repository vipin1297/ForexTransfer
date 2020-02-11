package com.fund.transfer.dto;

public class TransactionDto {
	
	private Long fromAcc;
	private Long toAcc;
	private Double Amount;
	public Long getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(Long fromAcc) {
		this.fromAcc = fromAcc;
	}
	public Long getToAcc() {
		return toAcc;
	}
	public void setToAcc(Long toAcc) {
		this.toAcc = toAcc;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}

}
