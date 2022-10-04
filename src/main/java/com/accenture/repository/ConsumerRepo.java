package com.accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.entity.BankAccountDetails;

public interface ConsumerRepo extends JpaRepository<BankAccountDetails, Integer>{

}
