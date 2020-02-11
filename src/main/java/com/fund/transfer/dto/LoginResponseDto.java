package com.fund.transfer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {

	private Integer statusCode;
	private String userName;
	private Long userId;

}
