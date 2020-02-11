package com.fund.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fund.transfer.constant.ApplicationConstant;
import com.fund.transfer.dto.ExchangeRateRequestDto;
import com.fund.transfer.dto.ExchangeRateResponseDto;
import com.fund.transfer.entity.Account;
import com.fund.transfer.repository.AccountRepository;
import com.fund.transfer.service.TransferService;
/**
 * 
 * @author Karthika T
 * @version 1.0
 *
 *
 **/
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class ExchangeRateController {
	
	@Autowired
	private TransferService transferService;
	
	@Autowired
	AccountRepository accountRepository;
	/**
	 * 
	 * @param ExchangeRateRequestDto 
	 * @return ExchangeRateResponseDto as response
	 * 
	 */
	@PostMapping("/rates")
	public ResponseEntity<ExchangeRateResponseDto> getExchangeRateAndCurrency(@RequestBody ExchangeRateRequestDto exchangeRateRequestDto){
		Account fromAcc=accountRepository.findByAccountNumber(exchangeRateRequestDto.getFromAccount());
		Account toAcc=accountRepository.findByAccountNumber(exchangeRateRequestDto.getToAccount());
		ExchangeRateResponseDto exchangeRateResponseDto= new ExchangeRateResponseDto();
		exchangeRateResponseDto.setStatusCode(ApplicationConstant.SUCCESS_CODE);
		exchangeRateResponseDto.setToCurrency(toAcc.getCurrency());
		exchangeRateResponseDto.setRate(transferService.getExchangeRates(fromAcc.getCurrency(), toAcc.getCurrency()));
		return new ResponseEntity<ExchangeRateResponseDto>(exchangeRateResponseDto, HttpStatus.OK);
		
	}

	
}
