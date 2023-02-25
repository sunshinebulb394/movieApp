package com.rendShow.subscriptionService.dto;

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
	private String email;
	private String subscriptionType;
	private BigDecimal price;
	private LocalDate subscriptionDate;
	private Integer usersAllowed;
    private Integer planValidity;
   

}
