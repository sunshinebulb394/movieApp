package com.rendShow.customerService.controller;

import java.util.List;

import com.rendShow.customerService.config.WebClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.rendShow.customerService.pojo.Customers;
import com.rendShow.customerService.repository.CustomerRepository;
import com.rendShow.customerService.service.CustomerService;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@Autowired
	private WebClientConfig webClientConfig;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customers customer) {
		Customers customers = service.createCustomer(customer);
		if(customers != null){
			return new ResponseEntity<String>("user exists", HttpStatus.OK);
		}

		customerRepository.save(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body("Customer successfully saved");
		
	}
//	@PostMapping("/customer-subscription")
//	public SubscriptionDto customerSubscription(@RequestBody SubscriptionDto subscriptionDto ){
////		return subscriptionDto;
//
//		SubscriptionDto sub = SubscriptionDto.builder()
//				.email(subscriptionDto.getEmail())
//				.price(subscriptionDto.getPrice())
//				.subscriptionType(subscriptionDto.getSubscriptionType())
//				.build();
//		return webClientConfig.webClientBuilder()
//				.build()
//				.post()
//				//send the request to the post method in ticket service
//				.uri("http://localhost:1003/api/subscription")
//				.body(Mono.just(sub),SubscriptionDto.class)
//				.retrieve()
//				.bodyToMono(SubscriptionDto.class)
//				.block();
//	}


	@GetMapping("/id/{id}")
	public ResponseEntity<?> getCustomerId(@PathVariable("id") Long id){
		Customers customer = service.getCustomerById(id);
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}
	
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getCustomerName(@PathVariable("name") String name){
		Customers customer = service.getCustomerByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}

	@GetMapping
	public List<Customers> getAllCustomers(){

		return customerRepository.findAll();
	}
}
