package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.InsuranceCompanies;
import com.java.service.InsuranceCompaniesService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/insurance")
@Api(value = "insurancecompanies",description = "REST API for list of insurance companies",tags = {"Insurance Companies"})

public class InsuranceCompaniesController {

	@Autowired
	private InsuranceCompaniesService comapnyService;

	@GetMapping("/insurances/listOfInsurances")
	public List<InsuranceCompanies> list() {
		return comapnyService.listcompanies();

	}

}
