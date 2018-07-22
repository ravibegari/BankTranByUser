package com.persistent.bankapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.persistent.bankapp.domain.BankMetaData;

public interface BankMetaDataDao extends CrudRepository<BankMetaData, Long> {
 
	
	 List<BankMetaData> findAll();
	}
