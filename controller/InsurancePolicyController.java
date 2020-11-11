package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.InsuranceTypeDTO;
import com.java.service.InsurancePolicyService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/insurance")
@Api(value = "insurance policies",description = "REST API for list of insurance policies",tags = {"Insurance Policies"})

public class InsurancePolicyController {

	@Autowired
	private InsurancePolicyService insuranceservicetype;

	@GetMapping("/insurances")
	public List<InsuranceTypeDTO> getInsurances(@RequestParam String insuranceName) {
		return insuranceservicetype.searchInsuranceName(insuranceName);

	}

}
