package com.java.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.dto.TransactionMasterRequest;

@FeignClient(name = "http://MYBANKSERVICE/bank")
public interface BankServiceClient {

	@GetMapping("/port")
	public String getInfo();

	@PostMapping("/fundtransfer")
	public String fundTransfer(@RequestBody TransactionMasterRequest transreq);
}