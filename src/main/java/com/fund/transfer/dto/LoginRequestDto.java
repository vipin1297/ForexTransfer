package com.fund.transfer.dto;

import javax.validation.constraints.NotBlank;

import com.fund.transfer.constant.ApplicationConstant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
	@NotBlank(message=ApplicationConstant.USERID_NOT_FOUND)
	private Long userId;
	@NotBlank(message=ApplicationConstant.PASSWORD_NOT_FOUND)
	private String password;

}
