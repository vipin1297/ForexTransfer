package com.fund.transfer.dto;

public class ExchangeRateRequestDto {
	
	private Long fromAccount;
	private Long toAccount;
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
	

}
