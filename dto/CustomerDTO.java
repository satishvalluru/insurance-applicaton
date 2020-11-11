package com.java.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.model.Insurances;

public class CustomerDTO {

	private Integer policyNumber;

	
	@NotEmpty(message = "Please provide a Customer Name")
	//@Size(max = 20, min = 1)
	private String customerName;

	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dateTime;

	private Double premiumAmount;

	private String status;

	private Insurances insurance;

	public Integer getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Insurances getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurances insurance) {
		this.insurance = insurance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
