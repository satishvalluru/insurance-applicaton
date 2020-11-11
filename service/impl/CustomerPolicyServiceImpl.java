package com.java.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.client.BankServiceClient;
import com.java.constants.Constants;
import com.java.dto.CustomerPolicyDTO;
import com.java.dto.InsurancesDTO;
import com.java.dto.TransactionMasterRequest;
import com.java.exception.CustomerNotFoundException;
import com.java.model.Customer;
import com.java.model.CustomerPolicy;
import com.java.model.Insurances;
import com.java.repository.CustomerPolicyRepository;
import com.java.repository.CustomerRepository;
import com.java.repository.InsuranceTypeRepository;
import com.java.service.CustomerPolicyService;

@Service
public class CustomerPolicyServiceImpl implements CustomerPolicyService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository custRepository;

	@Autowired
	private CustomerPolicyRepository custPolicyRepository;

	@Autowired
	private InsuranceTypeRepository typeRepository;

	@Autowired
	private BankServiceClient bankClient;

	@Override
	@Transactional
	public String enrollCustomerPolicy(CustomerPolicyDTO cusPolicyDTO) throws Exception {
		logger.debug("Started optUserPolicy method");
		//CustomerPolicy customerPolicy = new CustomerPolicy();
		double total = 0;
	
		Optional<Customer> customer = custRepository.findById(cusPolicyDTO.getCustomerId());
		if (customer.isPresent()) {
			if (!customer.isPresent()) {
				return null;
			}
	
			Map<Long, Double> insurancePaymentMap = new HashMap<>();
			Map<Long, Double> insurancePaymentResult = new HashMap<>();
	
			for (InsurancesDTO insuranceDto : cusPolicyDTO.getInsuranceDTO()) {
				CustomerPolicy customerpolicy = new CustomerPolicy();
				customerpolicy.setCustomerId(customer.get().getCustomerId());
				customerpolicy.setDateTime(Calendar.getInstance().getTime());
	
				Optional<Insurances> insurance = typeRepository.findById(insuranceDto.getInsuranceId());
				if (!insurance.isPresent()) {
					throw new CustomerNotFoundException("insurance id not found!!!!");
				}
	
				Insurances insurances = insurance.get();
				total = insuranceDto.getAmount();
	
				insurancePaymentResult = insurancePayment(insurances, insurancePaymentMap, insuranceDto.getAmount());
	
				customerpolicy.setInsurance(insurance.get());
				customerpolicy.setPremiumAmount(total);
	
				customerpolicy.setStatus(Constants.SUCCESS);
				custPolicyRepository.save(customerpolicy);
	
			}
			if (total == 0) {
				return null;
			}
	
			// customerPolicy.setPremiumAmount(total);
	
			TransactionMasterRequest fundRequest = new TransactionMasterRequest();
			fundRequest.setFromAccount(cusPolicyDTO.getUserAccountNumber());
			fundRequest.setRemarks(Constants.Remarks);
			String status = "";
	
			for (Map.Entry<Long, Double> entrySet : insurancePaymentResult.entrySet()) {
				fundRequest.setToAccount(entrySet.getKey());
				fundRequest.setAmount(entrySet.getValue());
				status = bankClient.fundTransfer(fundRequest);
				
			}
	
		} else {
			throw new CustomerNotFoundException("customer id not found!!!!");
		}
		logger.debug("Ended optUserPolicy method");
	
		return "Success";
	
	}

	private Map<Long, Double> insurancePayment(Insurances insurances, Map<Long, Double> insurancePaymentMap,
			double amount) {
		if (insurancePaymentMap.size() > 0) {
			Iterator<Long> iterator = insurancePaymentMap.keySet().iterator();

			while (iterator.hasNext()) {
				Long key = iterator.next();
				// Double value = insurancePaymentMap.get(key);
				// Double valueAmount = amount;
				if (key.equals(insurances.getInsurcompany().getCompanyAccountNumber())) {
					insurancePaymentMap.replace(key, amount);
				} else {
					insurancePaymentMap.put(insurances.getInsurcompany().getCompanyAccountNumber(), amount);

				}
			}
		}

		else {
			insurancePaymentMap.put(insurances.getInsurcompany().getCompanyAccountNumber(), amount);

		}

		return insurancePaymentMap;
	}

	@Override
	public List<CustomerPolicy> getCustomerById(int customerId) {
		return custPolicyRepository.findByCustomerId(customerId);
	}

}