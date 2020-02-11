package com.fund.transfer.dto;

import java.util.List;

public class AccountResponseDto {

	private int statusCode;
	private String message;
	private List<AccountDetail> acccountDetail;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<AccountDetail> getAcccountDetail() {
		return acccountDetail;
	}

	public void setAcccountDetail(List<AccountDetail> acccountDetail) {
		this.acccountDetail = acccountDetail;
	}

}
