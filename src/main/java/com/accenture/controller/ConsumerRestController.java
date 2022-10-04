package com.accenture.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.entity.BankAccountDetails;
import com.accenture.props.AppProperties;
import com.accenture.service.ConsumerService;
import com.accenture.util.KafkaConstants;


@RestController
public class ConsumerRestController {

	private ConsumerService consumerService;
	private Map<String, String> message;
	
	public ConsumerRestController(ConsumerService consumerService,AppProperties appProp)
	{
		this.consumerService = consumerService;
		this.message = appProp.getMessages();
	}
	
	@GetMapping("/gtAccntDtlsById/{id}")
	public ResponseEntity<BankAccountDetails> gtAccntById(@PathVariable("id") Integer id)
	{
		BankAccountDetails accountById = consumerService.getAccountById(id);
		return new ResponseEntity<>(accountById,HttpStatus.FOUND);
	}
	
	@GetMapping("/gtAllAccntDtls")
	public ResponseEntity<List<BankAccountDetails>> getAllAccnt()
	{
		List<BankAccountDetails> allAccnt = consumerService.getAllAccnt();
		return new ResponseEntity<>(allAccnt,HttpStatus.FOUND);
	}
	
	@PutMapping("/updtAccntDtls")
	public ResponseEntity<String> updtAccntDtls(@RequestBody BankAccountDetails bankAccountDetails)
	{
		Boolean updtAccntDtls = consumerService.updtAccntDtls(bankAccountDetails);
		if(updtAccntDtls!=null)
		{
			return new ResponseEntity<>(KafkaConstants.ACCOUNT_UPDATED_SUCC,HttpStatus.CREATED);
		}
		return new ResponseEntity<>(KafkaConstants.ACCOUNT_UPDATED_FAIL,HttpStatus.BAD_REQUEST);
	}

	
}
