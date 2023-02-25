package com.rendShow.customerService.dto;



import com.rendShow.customerService.pojo.Address;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

	private String customerId;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String email;
	private String password;
	
	@Embedded
	private Address address;

}
