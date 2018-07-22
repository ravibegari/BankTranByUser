package com.persistent.bankmetadata.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistent.bankmetadata.Dao.BankDao;
import com.persistent.bankmetadata.domain.Bank;
import com.persistent.bankmetadata.service.BankService;

import java.util.List;

@Service
@Transactional
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDao bankDao;

	public List<Bank> findAll() {
		return bankDao.findAll();
	}

}
