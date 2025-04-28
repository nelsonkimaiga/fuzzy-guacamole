package com.microservice.kcb.controller;

import com.microservice.kcb.dto.PaymentRequestDto;
import com.microservice.kcb.dto.TransactionRespDto;
import com.microservice.kcb.service.PayementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "kcb", produces = "application/json")
public class PaymentController {
	
	@Autowired
	PayementService paymentService;
	
	@PostMapping("/b2c")
	public ResponseEntity<TransactionRespDto> makeB2cPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
		return ResponseEntity.status(HttpStatus.OK).body(paymentService.initiateB2c(paymentRequestDto));
	}

}
