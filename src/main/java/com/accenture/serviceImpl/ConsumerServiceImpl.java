package com.accenture.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.accenture.entity.BankAccountDetails;
import com.accenture.repository.ConsumerRepo;
import com.accenture.service.ConsumerService;
import com.accenture.util.KafkaConstants;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Autowired
	ConsumerRepo consumerRepo;
	
	@Override
	@KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
	public BankAccountDetails listener(BankAccountDetails bankAccountDetails) {
		// TODO Auto-generated method stub
		System.out.println("task done "+bankAccountDetails);
		return consumerRepo.save(bankAccountDetails);
	}

	@Override
	public BankAccountDetails getAccountById(Integer id) {
		
		Optional<BankAccountDetails> findById = consumerRepo.findById(id);
		
		if(findById.isPresent())
		{
			 	return findById.get();
		}
		
		return null;
	}

	@Override
	public List<BankAccountDetails> getAllAccnt() {
		List<BankAccountDetails> findAll = consumerRepo.findAll();
		if(findAll!=null)
		{
			return findAll;
		}
		return null;
	}

	@Override
	public Boolean updtAccntDtls(BankAccountDetails bankAccountDetails) {
		return consumerRepo.save(bankAccountDetails)!=null;
	}

	
}
