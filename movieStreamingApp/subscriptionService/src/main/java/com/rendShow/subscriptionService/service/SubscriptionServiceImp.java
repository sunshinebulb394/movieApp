package com.rendShow.subscriptionService.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rendShow.subscriptionService.Repository.SubscriptionRepository;
import com.rendShow.subscriptionService.config.WebClientConfig;
import com.rendShow.subscriptionService.dto.CustomerResponse;
import com.rendShow.subscriptionService.dto.SubscriptionRequest;
import com.rendShow.subscriptionService.dto.SubscriptionResponse;
import com.rendShow.subscriptionService.pojo.Subscriptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class SubscriptionServiceImp implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private WebClientConfig webClient;

	

	@Override
	public void createSubscription(SubscriptionRequest subscriptionRequest) {

		Subscriptions subscriptions = Subscriptions.builder()
			   .subscriptionType(subscriptionRequest.getSubscriptionType())
			   .price(subscriptionRequest.getPrice())
			   .build();

		subscriptionRepository.save(subscriptions);
	}
//	public void createSubscription(SubscriptionRequest subscriptionRequest) {
//
//	   Subscriptions subscriptions = Subscriptions.builder()
//			   .subscriptionType(subscriptionRequest.getSubscriptionType())
//			   //.subscriptionDate(subscriptionRequest.getSubscriptionDate())
//			   .price(subscriptionRequest.getPrice())
//			  // .planValidity(subscriptionRequest.getPlanValidity())
//			 //  .usersAllowed(subscriptionRequest.getUsersAllowed())
//			   .build();
//	   CustomerResponse customerResponse = webClient.webClientBuilder()
//                       .build()
//                               .get()
//                                       .uri("http://customer_service/api/customer/id")
//                                               .retrieve()
//                                                       .bodyToMono(CustomerResponse.class)
//                                                               .block();
//
//	   subscriptionRepository.save(subscriptions);
////	   log.info("Subscription {} is saved", subscriptions.getPlanId());
//
//	}

	public List<SubscriptionResponse> getAllProducts() {
		List<Subscriptions> subscriptions = subscriptionRepository.findAll();
		return  subscriptions.stream().map(this::mapToSubscriptionResponse).toList();
		
		
	}
	
	private SubscriptionResponse mapToSubscriptionResponse(Subscriptions subscriptions) {
		return SubscriptionResponse.builder()
				.planId(subscriptions.getPlanId())
				.subscriptionType(subscriptions.getSubscriptionType())
				.price(subscriptions.getPrice())
				.planValidity(subscriptions.getPlanValidity())
				.usersAllowed(subscriptions.getUsersAllowed())
				.build();
	}
	
//	int planValidity = 30;
//	SubscriptionService subscriptionService = new SubscriptionService();
//	LocalDate startDate = LocalDate.of(2023, 2, 21);
//	int planValidityDays = 30;
//	LocalDate endDate = subscriptionService.calculateEndDate(startDate, planValidityDays);
//	System.out.println("Subscription end date: " + endDate);

	
	
	public LocalDate calculateEndDate(LocalDate subscriptionDate, int planValidity) {
		return subscriptionDate.plusMonths(planValidity);
	}
	
	
	

//	@Override
//	public Subscriptions getSubscriptionById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Subscriptions> getAllSubscriptions() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Subscriptions updateSubscription(Subscriptions subscription) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteSubscriptionById(Long id) {
//		// TODO Auto-generated method stub
//
//	}
//	
//	@Override
//	  public List<Subscriptions> getSubscriptionsByType(String subscriptionType) {
//	    return subscriptionRepository.findBySubscriptionType(subscriptionType);
//	  }
//
//	  @Override
//	  public List<Subscriptions> getSubscriptionsByPriceRange(Double minPrice, Double maxPrice) {
//	    return subscriptionRepository.findByPriceBetween(minPrice, maxPrice);
//	  }
//
//	  @Override
//	  public List<Subscriptions> getSubscriptionsByDateRange(LocalDate startDate, LocalDate endDate) {
//	    return subscriptionRepository.findBySubscriptionDateBetween(startDate, endDate);
//	  }
//	  
//	  
//	  public LocalDate calculateExpirationDate(LocalDate startDate, Integer planValidity){
//		  return startDate.plusMonths(planValidity);
//	  }
//	  
//	  
//	 
//	  
//	  public boolean canAccess(int usersTryingToAccess, int maxUsersAllowed) {
//	        return usersTryingToAccess <= maxUsersAllowed;
//	    }
//	  
//	    public boolean validateInput(Subscriptions subscription) {
//	        // code to validate the user's input
//	        return isValid;
//	    }
//
//	  
//	  public Subscriptions getPlanDetails(Long planId) {
//	        // code to retrieve the plan details from the database
//		  Subscriptions plan = getPlanDetails(planId);
//		    if(validateInput(subscription) && isPlanAvailable(planId)){
//		        Long subscriptionId = createSubscription(subscription, userId);
//		        sendConfirmationEmail(email, subscription);
//		    }
//	        return plan;
//	    }
//	  
//	  


}
