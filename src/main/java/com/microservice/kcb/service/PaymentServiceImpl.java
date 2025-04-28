package com.microservice.kcb.service;

import com.microservice.kcb.dto.PaymentRequestDto;
import com.microservice.kcb.dto.TransactionRespDto;
import com.microservice.kcb.model.B2c;
import com.microservice.kcb.repository.B2cRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class PaymentServiceImpl implements PayementService {
	
	@Autowired
	MnoService mnoService;

	@Autowired
	SmsService smsService;
	
	@Autowired
	B2cRepository b2cRepository;
	
	@Override
	public TransactionRespDto initiateB2c(PaymentRequestDto paymentRequestDto) {
		try {
			String phoneNumber = paymentRequestDto.getPhoneNumber();
			double amount = paymentRequestDto.getAmount();
			String transactionRef = generateTransactionRef();
			
			TransactionRespDto mnoResponse = mnoService.sendB2c(phoneNumber, amount, transactionRef);
			
			if (mnoResponse.isSuccessful()) {
				
				log.info("b2c Payment was successful, sending SMS notification..: {}", mnoResponse.getMessage());
				
				
				// send SMS notification
				smsService.sendSms(phoneNumber, mnoResponse.getMessage());
				
				//persist to db::
				B2c b2c = new B2c();
				
				b2c.setAmount(BigDecimal.valueOf(amount));
				b2c.setPhoneNumber(phoneNumber);
				b2c.setTransactionId(transactionRef);
				b2c.setTransactionDate(new Date());
				
				b2cRepository.save(b2c);
				log.info("Transaction saved -> {}", b2c);
			} else {
				log.warn("b2c Payment failed: {}", mnoResponse.getMessage());
			}
			
			return mnoResponse;
			
		}
		catch (Exception ex) {
			log.error("error occurred while initiating b2c payment: {}", ex.getMessage());
			
			TransactionRespDto errorResponse = new TransactionRespDto();
			errorResponse.setSuccessful(false);
			errorResponse.setMessage("error occurred while processing b2c payment.");
			return errorResponse;
		}
	}
	
	private String generateTransactionRef() {
		return UUID.randomUUID().toString();
	}
}
