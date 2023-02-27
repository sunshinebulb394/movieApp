package com.rendShow.subscriptionService.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto {
	private String email;
	private String subscriptionType;
	private BigDecimal price;
	private Integer usersAllowed ;
	private Integer planValidity ;

}
