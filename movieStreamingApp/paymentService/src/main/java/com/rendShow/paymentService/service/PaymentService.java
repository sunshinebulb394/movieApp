package com.rendShow.paymentService.service;

import com.rendShow.paymentService.dto.PaymentRequest;

public interface PaymentService {
	
	void createPayment(PaymentRequest paymentRequest);

}
