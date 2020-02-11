package com.fund.transfer.dto;

public class TransactionDto {
	
	private Long fromAcc;
	private Long toAcc;
	private Double amount;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
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
	

}
