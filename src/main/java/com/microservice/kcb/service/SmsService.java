package com.microservice.kcb.service;

public interface SmsService {
	
	void sendSms(String phoneNumber, String message);
	
}
