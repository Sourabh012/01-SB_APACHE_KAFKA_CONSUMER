package com.accenture.serviceImpl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.accenture.entity.BankAccountDetails;
import com.accenture.service.ConsumerService;
import com.accenture.util.KafkaConstants;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Override
	@KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
	public BankAccountDetails listener(BankAccountDetails bankAccountDetails) {
		// TODO Auto-generated method stub
		System.out.println("task done "+bankAccountDetails);
		return null;
	}

	
}
