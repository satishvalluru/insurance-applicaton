package com.java.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.InsuranceCompanies;
import com.java.repository.InsuranceCompanyRepository;
import com.java.service.InsuranceCompaniesService;

@Service
public class InsuranceCompaniesServiceImpl implements InsuranceCompaniesService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private InsuranceCompanyRepository companyRepository;
	
	@Override
	public List<InsuranceCompanies> listcompanies() {
		logger.debug("Started list of companies method");
		return companyRepository.findAll();
	}
	
	

}
