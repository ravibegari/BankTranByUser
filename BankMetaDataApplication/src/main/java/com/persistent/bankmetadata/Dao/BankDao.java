package com.persistent.bankmetadata.Dao;


import org.springframework.data.repository.CrudRepository;

import com.persistent.bankmetadata.domain.Bank;

import java.util.List;

public interface BankDao extends CrudRepository<Bank, Long> {

    List<Bank> findAll();
}