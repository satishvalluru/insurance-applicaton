package com.java.service;

import java.util.List;

import com.java.dto.InsuranceTypeDTO;

public interface InsurancePolicyService {
	
	public List<InsuranceTypeDTO> searchInsuranceName(String insuranceName);

}
