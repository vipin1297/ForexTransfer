package com.fund.transfer.dto;

import javax.validation.constraints.NotBlank;

import com.fund.transfer.constant.ApplicationConstant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
	@NotBlank(message=ApplicationConstant.USERID_NOT_FOUND)
	private String userName;
	@NotBlank(message=ApplicationConstant.PASSWORD_NOT_FOUND)
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
