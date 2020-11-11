package com.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CustomerDTO;
import com.java.dto.CustomerPolicyDTO;
import com.java.dto.CustomerRequestDTO;
import com.java.service.CustomerPolicyService;
import com.java.service.CustomerService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/insurance")
@Api(value = "customerpolicies",description = "REST API for list of customer policies",tags = {"Customer Policies"})
public class CustomerPolicyController {

	@Autowired
	private CustomerPolicyService customerPolicyService;

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<String> saveCustomers(@Valid @RequestBody CustomerRequestDTO customerDto) throws Exception {
		customerService.saveCustomer(customerDto);
		return new ResponseEntity<String>(" customer registered successfully", HttpStatus.CREATED);

	}

	@GetMapping("/customers/listOfInsurancesByCustomerId/{customerId}")
	public ResponseEntity<List<CustomerDTO>> searchCustomers(@PathVariable("customerId") int customerId, int pageNumber,
			int pageSize) {
		List<CustomerDTO> customers = customerService.searchCustomers(customerId, pageNumber, pageSize);
		return new ResponseEntity<>(customers, HttpStatus.CREATED);

	}

	@PostMapping("/customers/enrollPolicies")
	public ResponseEntity<String> enrollCustomerPolicy(@RequestBody CustomerPolicyDTO cusPolicyDTO) throws Exception {
		customerPolicyService.enrollCustomerPolicy(cusPolicyDTO);
		return new ResponseEntity<String>(" customer policy registered successfully", HttpStatus.CREATED);

	}

}
