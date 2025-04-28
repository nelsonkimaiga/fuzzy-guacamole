package com.microservice.kcb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
public class B2c {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String transactionId;
	BigDecimal amount;
	String phoneNumber;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date transactionDate;
}
