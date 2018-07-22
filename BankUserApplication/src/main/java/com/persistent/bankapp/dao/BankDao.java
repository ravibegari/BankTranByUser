package com.persistent.bankapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.persistent.bankapp.domain.Bank;



public interface BankDao extends CrudRepository<Bank, Long> {
	
	List<Bank> findAll();
}
