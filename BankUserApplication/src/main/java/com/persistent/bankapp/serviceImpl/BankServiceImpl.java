package com.persistent.bankapp.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.bankapp.dao.BankDao;
import com.persistent.bankapp.domain.Bank;
import com.persistent.bankapp.service.BankService;


@Service
@Transactional
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDao bankDao;
	@Override
	public List<Bank> findAllBanks() {
		// TODO Auto-generated method stub
		return bankDao.findAll();
	}

}
