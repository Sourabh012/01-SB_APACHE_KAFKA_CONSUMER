package com.accenture.service;

import java.util.List;

import com.accenture.entity.BankAccountDetails;

public interface ConsumerService {

	public BankAccountDetails listener(BankAccountDetails bankAccountDetails);
	
    public BankAccountDetails getAccountById(Integer id);
	
	public List<BankAccountDetails> getAllAccnt();
	
	public Boolean updtAccntDtls(BankAccountDetails bankAccountDetails);
	
}
