package com.microservice.kcb;

import com.microservice.kcb.dto.PaymentRequestDto;
import com.microservice.kcb.dto.TransactionRespDto;
import com.microservice.kcb.service.MnoService;
import com.microservice.kcb.service.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PaymentServiceImplTest {
	@InjectMocks
	private PaymentServiceImpl paymentService;
	
	@Mock
	private MnoService mnoService;
	
	
	@Test
	void testInitiateB2c() {
		PaymentRequestDto requestDto = new PaymentRequestDto();
		requestDto.setPhoneNumber("254712345678");
		requestDto.setAmount(500.0);
		
		TransactionRespDto mnoResponse = new TransactionRespDto();
		mnoResponse.setSuccessful(true);
		mnoResponse.setMessage("Payment successful");
		
		when(mnoService.sendB2c(anyString(), anyDouble(), anyString())).thenReturn(mnoResponse);
		TransactionRespDto response = paymentService.initiateB2c(requestDto);
	}
	
}
