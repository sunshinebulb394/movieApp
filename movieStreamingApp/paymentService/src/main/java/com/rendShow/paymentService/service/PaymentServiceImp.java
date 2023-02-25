package com.rendShow.paymentService.service;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rendShow.paymentService.config.WebClientConfig;
import com.rendShow.paymentService.dto.PaymentResponse;
import com.rendShow.paymentService.dto.PaymentRequest;
import com.rendShow.paymentService.pojo.Payments;
import com.rendShow.paymentService.repository.PaymentRepository;

@Service
@Transactional
public class PaymentServiceImp implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private WebClientConfig webClient;
	

	@Override
	public void createPayment(PaymentRequest paymentRequest) {
		
		
		

	}
	
	
	private Date calculateNextRenewalDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
		
	}
	
	
       
	
	private PaymentResponse mapToDto(Payments payment) {
		PaymentResponse paymentItems = new PaymentResponse();
		paymentItems.setAmountPaid(payment.getAmountPaid());
		paymentItems.setNextRenewalDate(calculateNextRenewalDate());
		paymentItems.setPaymentDate(payment.getPaymentDate());
		paymentItems.setPaymentMethod(payment.getPaymentMethod());
		return paymentItems;
		
	}
	
   

}
