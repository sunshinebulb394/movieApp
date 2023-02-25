package com.rendShow.customerService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.rendShow.customerService.dto.CustomerRequest;
import com.rendShow.customerService.dto.CustomerResponse;
import com.rendShow.customerService.pojo.Customers;
import com.rendShow.customerService.repository.CustomerRepository;


@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void createCustomer(CustomerRequest customerRequest) {
		Customers customer = Customers.builder()
				.firstName(customerRequest.getFirstName())
				.lastName(customerRequest.getLastName())
				.email(customerRequest.getEmail())
				.password(customerRequest.getPhoneNo())
				.phoneNo(customerRequest.getPhoneNo())
				.address(customerRequest.getAddress())
				.build();
		customerRepository.save(customer);
		
	}
	
	@Override
	public List<CustomerResponse> getAllCustomers() {
		List<Customers> customer = customerRepository.findAll();
		return customer.stream()
				.map(this::mapToCustomerResponse)
				.toList();
	}
	
	
	private CustomerResponse mapToCustomerResponse(Customers customer) {
		return CustomerResponse.builder()
				.id(customer.getId())
				.firstName(customer.getFirstName())				
				.lastName(customer.getLastName())
				.phoneNo(customer.getPhoneNo())
				.email(customer.getEmail())
				.password(customer.getPassword())
				.address(customer.getAddress())
				.build();
	}
	

//	@Override
//	public CustomerResponse findById(Long id) {
//	    Customers customer = customerRepository.findById(id)
//	            .orElseThrow(() -> new RuntimeException("Customer not found"));
//	    return CustomerResponse.builder()
//	            .id(customer.getId())
//	            .firstName(customer.getFirstName())
//	            .lastName(customer.getLastName())
//	            .phoneNo(customer.getPhoneNo())
//	            .email(customer.getEmail())
//	            .build();
//	}

	@Override
	public Customers getCustomerById(Long id) {
		Optional<Customers> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		return null;
	}

		


//	@Override
//	public CustomerResponse getByName(String name) {
//		Customers customer = customerRepository.findByNameIn(name)
//				.orElseThrow();
//		return CustomerResponse.builder()
//				.id(customer.getId())
//				.firstName(customer.getFirstName())
//				.lastName(customer.getLastName())
//				.phoneNo(customer.getPhoneNo())
//				.build();
//		return customerRepository.findAll()
//				.stream()
//				.filter(customer -> customer.getFirstName().equals(name) || customer.getLastName().equals(name))
//				.findAny()
//				.orElseThrow();
	//}

	

	
}


