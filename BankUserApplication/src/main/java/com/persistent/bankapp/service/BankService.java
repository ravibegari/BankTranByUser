package com.persistent.bankapp.service;

import java.util.List;

import com.persistent.bankapp.domain.Bank;


public interface BankService {
	
	public List<Bank> findAllBanks();
	
}
