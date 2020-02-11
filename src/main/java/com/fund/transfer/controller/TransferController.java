package com.fund.transfer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fund.transfer.constant.ApplicationConstant;
import com.fund.transfer.dto.ResponseDto;
import com.fund.transfer.dto.TransactionDto;
import com.fund.transfer.exception.ImProperDataException;
import com.fund.transfer.service.TransferService;

/**
 * 
 * @author Karthika T
 * @version 1.0
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/users")
public class TransferController {
	private static final Logger logger = LoggerFactory.getLogger(TransferController.class);
	
	@Autowired
	private TransferService transferService;
	
	@PostMapping("/{userId}/transactions")
	public ResponseEntity<ResponseDto> transfer(@RequestBody TransactionDto transactionDto, @PathVariable Long userId){
		logger.info(ApplicationConstant.INSIDE_TRANSFER_CONTROLLER );
		ResponseDto responseDto=transferService.transfer(transactionDto, userId);
		/*
		 * if(!(responseDto==null)) { logger.error(ApplicationConstant.INVALID_DATA);
		 * throw new ImProperDataException(ApplicationConstant.INVALID_DATA); }
		 */
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

}
