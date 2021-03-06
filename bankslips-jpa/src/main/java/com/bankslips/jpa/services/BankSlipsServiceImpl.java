package com.bankslips.jpa.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankslips.jpa.entities.BankSlipJPAEntity;
import com.bankslips.jpa.repository.BankSlipRepository;

@Service
public class BankSlipsServiceImpl implements BankSlipsService {
	
	private static final Logger log = LoggerFactory.getLogger(BankSlipsServiceImpl.class);
	
	@Autowired
	private BankSlipRepository bankSlipRepository;
	
	@Override
	public Optional<BankSlipJPAEntity> findById(String id) {
		log.info("Finding BankSlip by ID: {}.", id);
		return this.bankSlipRepository.findById(id);
	}
	
	@Override
	public List<BankSlipJPAEntity> getAll() {
		log.info("Finding all the BankSlip.");
		return this.bankSlipRepository.findAll();
	}
	
	@Override
	public BankSlipJPAEntity persist(BankSlipJPAEntity bankSlip) {
		log.info("Saving BankSlip: {}", bankSlip);
				
		return this.bankSlipRepository.save(bankSlip);
	}

	@Override
	public void delete(BankSlipJPAEntity bankSlip) {
		this.bankSlipRepository.delete(bankSlip);
	}	
}
