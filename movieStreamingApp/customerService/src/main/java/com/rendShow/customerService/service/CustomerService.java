package com.rendShow.customerService.service;

import java.util.List;


import com.rendShow.customerService.pojo.Customers;

public interface CustomerService {
	
	Customers createCustomer(Customers customers);
	
//	CustomerResponse findById(Long id);
    Customers getCustomerById(Long id);
	
//	CustomerResponse getByName(String name);

	Customers getCustomerByName(String name);

}
