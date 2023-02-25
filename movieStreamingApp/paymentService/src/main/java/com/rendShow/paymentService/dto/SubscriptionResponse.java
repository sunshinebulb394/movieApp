package com.rendShow.paymentService.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionResponse {
	
	@Id
	private Long planId;	
	private String subscriptionType;
	private BigDecimal price;
	private LocalDate subscriptionDate = LocalDate.now();
	private Integer usersAllowed = 5;
    private Integer planValidity = 30;
   

}
