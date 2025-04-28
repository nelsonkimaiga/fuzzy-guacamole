package com.microservice.kcb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRespDto {
	boolean successful;
	String message;
}
