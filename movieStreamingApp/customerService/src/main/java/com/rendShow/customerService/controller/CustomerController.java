package com.rendShow.customerService.controller;

import java.util.List;

import com.rendShow.customerService.config.WebClientConfig;
import com.rendShow.customerService.dto.SubcriptionDto;
import com.rendShow.customerService.dto.SubscriptionDto;
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

import com.rendShow.customerService.dto.CustomerRequest;
import com.rendShow.customerService.dto.CustomerResponse;
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
	public void addCustomer(@RequestBody CustomerRequest customerRequest) {
		service.createCustomer(customerRequest);
//		if(cust != null) {
//			return new ResponseEntity<String>("user exists", HttpStatus.OK);
//		}
//		
//		customerRepository.save(customers);
//		return ResponseEntity.status(HttpStatus.CREATED).body("Customer successfully saved");
		
	}

	@PostMapping("/customer-subscription")
	public SubscriptionDto customerSubscription(@RequestBody SubscriptionDto subscriptionDto ){
//		return subscriptionDto;

		SubscriptionDto sub = SubscriptionDto.builder()
				.email(subscriptionDto.getEmail())
				.price(subscriptionDto.getPrice())
				.subscriptionType(subscriptionDto.getSubscriptionType())
				.build();
		return webClientConfig.webClientBuilder()
				.build()
				.post()
				//send the request to the post method in ticket service
				.uri("http://subsription_service/api/subscription")
				.body(Mono.just(sub),SubscriptionDto.class)
				.retrieve()
				.bodyToMono(SubscriptionDto.class)
				.block();
	}
	
//	@GetMapping("/id")
//	public CustomerResponse getCustomerId(@RequestParam("id") Long id) {
//		return service.findById(id);
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Customers> getCustomer(@PathVariable Long id) {
		Customers customer = service.getCustomerById(id);
		if (customer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer);
	}
	
//	@GetMapping("/name")
//	public CustomerResponse getCustomerName(@RequestParam("name") String name) {
//
//		return service.getByName(name);
//	}
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getCustomerId(@PathVariable("id") Long id){
//		Customers customer = service.findById(id);
//		return ResponseEntity.status(HttpStatus.OK).body(customer);
//	}
	
	
//	@GetMapping("/{name}")
//	public ResponseEntity<?> getCustomerName(@PathVariable("name") String name){
//		Customers customer = service.getByName(name);
//		return ResponseEntity.status(HttpStatus.OK).body(customer);
//	}

	@GetMapping
	public List<CustomerResponse> getAllCustomers(){

		return service.getAllCustomers();
	}
}
