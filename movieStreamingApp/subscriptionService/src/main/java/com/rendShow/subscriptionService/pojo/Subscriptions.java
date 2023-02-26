package com.rendShow.subscriptionService.pojo;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
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
	@Enumerated(EnumType.STRING)
	private SubscriptionType subscriptionType;
	private Double price;
	private LocalDate subscriptionDate = LocalDate.now();
	private Integer usersAllowed;
    private Integer planValidity;
   


}
