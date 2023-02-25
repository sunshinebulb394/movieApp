package com.rendShow.subscriptionService.pojo;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Subscriptions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long planId;
	private String customerId;
	private String subscriptionType;
	private BigDecimal price;
	private LocalDate subscriptionDate = LocalDate.now();
	private Integer usersAllowed = 5;
    private Integer planValidity = 30;
   


}
