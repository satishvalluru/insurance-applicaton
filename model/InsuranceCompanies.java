package com.java.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "insurancecompanies")
public class InsuranceCompanies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer companyId;

	private String companyName;

	private String companyPhone;

	private String companyEmail;

	private String companyAddress;
	
	private Long companyAccountNumber;

	@OneToMany(mappedBy = "insurcompany")
	@JsonManagedReference
	private List<Insurances> insurances;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public List<Insurances> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurances> insurances) {
		this.insurances = insurances;
	}

	public Long getCompanyAccountNumber() {
		return companyAccountNumber;
	}

	public void setCompanyAccountNumber(Long companyAccountNumber) {
		this.companyAccountNumber = companyAccountNumber;
	}

}
