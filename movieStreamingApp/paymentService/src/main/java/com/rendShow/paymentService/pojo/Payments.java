package com.rendShow.paymentService.pojo;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;




import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Payments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long paymentId;
	private BigDecimal amountPaid;
	private LocalDate paymentDate = LocalDate.now();
	private Date nextRenewalDate;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	

	
}
