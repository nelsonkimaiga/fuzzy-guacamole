package com.microservice.kcb.service;

import com.microservice.kcb.dto.TransactionRespDto;
import org.springframework.stereotype.Service;

@Service
public class MnoServiceImpl implements MnoService {
	
	@Override
	public TransactionRespDto sendB2c(String phoneNumber, double amount, String transactionRef) {
		return null;
	}
}
