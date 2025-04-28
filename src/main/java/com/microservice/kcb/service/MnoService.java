package com.microservice.kcb.service;

import com.microservice.kcb.dto.TransactionRespDto;

public interface MnoService {
	TransactionRespDto sendB2c(String phoneNumber, double amount, String transactionRef);
}
