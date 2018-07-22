package com.persistent.bankapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistent.bankapp.dao.BankMetaDataDao;
import com.persistent.bankapp.domain.BankMetaData;
import com.persistent.bankapp.service.BankMetaDataService;

@Service
@Transactional
public class BankMetaDataImpl implements BankMetaDataService {

	@Autowired
	private BankMetaDataDao bankMetaDataDao;
	
	@Override
	public List<BankMetaData> getMetaData() {
		// TODO Auto-generated method stub
		return bankMetaDataDao.findAll();
	}

}
