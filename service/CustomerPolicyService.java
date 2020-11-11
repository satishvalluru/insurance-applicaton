package com.java.service;

import java.util.List;

import com.java.dto.CustomerPolicyDTO;
import com.java.model.CustomerPolicy;

public interface CustomerPolicyService {

	public List<CustomerPolicy> getCustomerById(int customerId);

	public String enrollCustomerPolicy(CustomerPolicyDTO cusPolicyDTO) throws Exception;

}
