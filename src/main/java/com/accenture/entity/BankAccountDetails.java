package com.accenture.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity 
public class BankAccountDetails {

	@Id
	private Integer accountId;
	
	private Integer bankID;
	
	private String accountType;
	
	private Integer balance;
	
	private String country;
	
	 @JsonFormat(pattern = "yyyy/MM/dd")
		private Date accountCreatedDate;
}
