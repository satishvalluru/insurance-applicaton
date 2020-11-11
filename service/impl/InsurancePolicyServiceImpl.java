package com.java.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.InsuranceTypeDTO;
import com.java.model.Insurances;
import com.java.repository.InsuranceTypeRepository;
import com.java.service.InsurancePolicyService;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private InsuranceTypeRepository typeRepository;

	@Override
	public List<InsuranceTypeDTO> searchInsuranceName(String insuranceName) {
		logger.debug("Started search insurance name method");
		List<Insurances> insuranceType = typeRepository.findByInsuranceNameContains(insuranceName);
		List<InsuranceTypeDTO> insuranceTypeDtos = new ArrayList<>();
		

		insuranceType.stream().forEach(insuranceDtos -> {
			InsuranceTypeDTO insuranceDto = new InsuranceTypeDTO();
			BeanUtils.copyProperties(insuranceDtos, insuranceDto);
			insuranceTypeDtos.add(insuranceDto);
		});

		logger.debug("Ended search insurance name method");
		return insuranceTypeDtos;
	}
}












//InsuranceTypeDTO insuranceDto = null;
		/*
		 * for (Insurances insuranceDtos : insuranceType) { insuranceDto = new
		 * InsuranceTypeDTO(); BeanUtils.copyProperties(insuranceDtos, insuranceDto);
		 * insuranceTypeDtos.add(insuranceDto); }
		 */
