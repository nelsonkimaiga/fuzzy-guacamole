package com.microservice.kcb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {
	
	@Override
	public void sendSms(String phoneNumber, String message) {
		//sms logic
		log.info("Sending SMS to {} with message: {}", phoneNumber, message);
	}
}
