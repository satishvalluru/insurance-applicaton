package com.java.service;

import java.util.List;

import com.java.dto.CustomerDTO;
import com.java.dto.CustomerRequestDTO;

public interface CustomerService {

	public List<CustomerDTO> searchCustomers(Integer customerId, Integer pageNumber, Integer pageSize);

	CustomerRequestDTO saveCustomer(CustomerRequestDTO customerDto);

}
