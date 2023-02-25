package com.rendShow.customerService.service;

import java.util.List;

import com.rendShow.customerService.dto.CustomerRequest;
import com.rendShow.customerService.dto.CustomerResponse;
import com.rendShow.customerService.pojo.Customers;

public interface CustomerService {
	
	void createCustomer(CustomerRequest customerRequest);
	
//	CustomerResponse findById(Long id);
    Customers getCustomerById(Long id);
	
//	CustomerResponse getByName(String name);

	List<CustomerResponse> getAllCustomers();

}
