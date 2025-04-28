package com.microservice.kcb.service;

import com.microservice.kcb.dto.PaymentRequestDto;
import com.microservice.kcb.dto.TransactionRespDto;

public interface PayementService {
	
	TransactionRespDto initiateB2c(PaymentRequestDto paymentRequestDto);
}
