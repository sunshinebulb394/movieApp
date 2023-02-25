package com.rendShow.paymentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rendShow.paymentService.dto.PaymentRequest;
import com.rendShow.paymentService.service.PaymentServiceImp;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	@Autowired
	private PaymentServiceImp paymentService;
	
	@PostMapping
	public String makePayment(@RequestBody PaymentRequest paymentRequest) {
		paymentService.createPayment(paymentRequest);
		return "Payment made successfully";
	}

}
