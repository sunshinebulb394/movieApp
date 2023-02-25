package com.rendShow.subscriptionService.dto;



import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerResponse {
	
    @Id
	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String email;
	private String password;
	
	

}
