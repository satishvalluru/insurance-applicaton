package com.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "insurances")
public class Insurances {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer insuranceId;

	private String insuranceName;

	private Double sumInsured;

	private String period;

	@ManyToOne
	@JsonBackReference
	private InsuranceCompanies insurcompany;

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public Double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(Double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public InsuranceCompanies getInsurcompany() {
		return insurcompany;
	}

	public void setInsurcompany(InsuranceCompanies insurcompany) {
		this.insurcompany = insurcompany;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

}