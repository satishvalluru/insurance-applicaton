package com.java.dto;

import java.util.List;

public class CustomerPolicyDTO {

	private Integer userAccountNumber;

	private Integer customerId;

	private List<InsurancesDTO> insuranceDTO;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public List<InsurancesDTO> getInsuranceDTO() {
		return insuranceDTO;
	}

	public void setInsuranceDTO(List<InsurancesDTO> insuranceDTO) {
		this.insuranceDTO = insuranceDTO;
	}

	public Integer getUserAccountNumber() {
		return userAccountNumber;
	}

	public void setUserAccountNumber(Integer userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}

}
