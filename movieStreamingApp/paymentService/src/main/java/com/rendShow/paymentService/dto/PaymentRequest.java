package com.rendShow.paymentService.dto;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.rendShow.paymentService.pojo.PaymentMethod;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
	
	private BigDecimal amountPaid;
	private LocalDate paymentDate = LocalDate.now();
	private Date nextRenewalDate;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

}
