package com.fund.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fund.transfer.dto.ResponseDto;
import com.fund.transfer.dto.TransactionDto;
import com.fund.transfer.service.TransferService;

/*
 * this is used to perform transaction
 */

@RestController
@RequestMapping("/users")
public class TransferController {
	
	@Autowired
	private TransferService transferService;
	
	@PostMapping("/{userId}/transactions")
	public ResponseEntity<ResponseDto> transfer(@RequestBody TransactionDto transactionDto, @PathVariable Long userId){
		ResponseDto responseDto=transferService.transfer(transactionDto, userId);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

}
