package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.dto.CustomerDTO;
import com.java.dto.CustomerRequestDTO;
import com.java.model.Customer;
import com.java.model.CustomerPolicy;
import com.java.repository.CustomerInsuranceRepository;
import com.java.repository.CustomerRepository;
import com.java.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerInsuranceRepository customerInsuranceRepository;

	@Autowired
	CustomerRepository customerRepository;

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public List<CustomerDTO> searchCustomers(Integer customerId, Integer pageNumber, Integer pageSize) {
		logger.debug("Started search customers method");
		List<CustomerDTO> customerInsuranceResponseDtoList = new ArrayList<>();
		try {
			logger.info("searchCustomerById in service..." + customerId);
			Pageable pageable = PageRequest.of(pageNumber, pageSize);
			List<CustomerPolicy> customerList = customerInsuranceRepository.findByCustomerId(customerId, pageable);

			
			customerList.stream().forEach(customerInsurance -> {
				logger.info("customerInsuranceList:::" + customerInsurance);

				CustomerDTO customerDto = new CustomerDTO();
				BeanUtils.copyProperties(customerInsurance, customerDto);

				Optional<Customer> cust = customerRepository.findById(customerInsurance.getCustomerId());

				customerDto.setCustomerName(cust.get().getCustomerName());

				customerInsuranceResponseDtoList.add(customerDto);
			});

		} catch (Exception e) {
			logger.info("exception::" + e.getMessage());
		}
		logger.debug("Ended search customers method");

		return customerInsuranceResponseDtoList;
	}

	@Override
	public CustomerRequestDTO saveCustomer(CustomerRequestDTO customerDto) {
		Customer customers = new Customer();
		BeanUtils.copyProperties(customerDto, customers);
		customerRepository.save(customers);
		return customerDto;
	}

}














//customerDto = null;
			/*
			 * for (CustomerPolicy customerInsurance : customerList) {
			 * logger.info("customerInsuranceList:::" + customerInsurance); customerDto =
			 * new CustomerDTO(); BeanUtils.copyProperties(customerInsurance, customerDto);
			 * 
			 * Optional<Customer> cust =
			 * customerRepository.findById(customerInsurance.getCustomerId());
			 * 
			 * 
			 * customerDto.setCustomerName(cust.get().getCustomerName());
			 * 
			 * customerInsuranceResponseDtoList.add(customerDto); }
			 */
