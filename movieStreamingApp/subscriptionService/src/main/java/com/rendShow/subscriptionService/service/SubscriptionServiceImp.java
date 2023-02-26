package com.rendShow.subscriptionService.service;

import java.time.LocalDate;
import java.util.List;

import com.rendShow.subscriptionService.dto.CustomersDto;
import com.rendShow.subscriptionService.pojo.SubscriptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rendShow.subscriptionService.Repository.SubscriptionRepository;
import com.rendShow.subscriptionService.config.WebClientConfig;
import com.rendShow.subscriptionService.pojo.Subscriptions;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class SubscriptionServiceImp implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private WebClientConfig webClientConfig;

	

	@Override
	public Subscriptions createSubscription(Subscriptions subscriptions) {
//		int userAllowed = 5;
//		int usersTryingToAccess = subscriptions.getUsersAllowed();
//		if(usersTryingToAccess > userAllowed){
//			throw new AccessDeniedException("Maximum number of users exceeded.");
//		}

		double price = subscriptions.getPrice();
		String subscriptionType = String.valueOf(subscriptions.getSubscriptionType());
		if(subscriptionType.equals("Basic")){
			price +=100;
		} else if (subscriptionType.equals("Standard")) {
			price +=150;
		} else if (subscriptionType.equals("Premium")) {
			price +=200;
		}
		Subscriptions subscription = Subscriptions.builder()
				.planId(subscriptions.getPlanId())
				.price(price)
				.subscriptionType(SubscriptionType.valueOf(subscriptionType))
				.subscriptionDate(calculateEndDate())
				.usersAllowed(subscriptions.getUsersAllowed())
				.build();

		return webClientConfig.webClientBuilder()
				.build()
				.post()
				.uri("http://localhost:1001/api/customer", CustomersDto.builder())
				.body(Mono.just(subscription), Subscriptions.class)
				.retrieve()
				.bodyToMono(Subscriptions.class)
				.block();



	}

	private LocalDate calculateEndDate() {
		int planValidity = 30;
		LocalDate subscriptionDate = LocalDate.now();
		return (LocalDate) subscriptionDate.plusMonths(planValidity);
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


	
//	private SubscriptionResponse mapToSubscriptionResponse(Subscriptions subscriptions) {
//		return SubscriptionResponse.builder()
//				.planId(subscriptions.getPlanId())
//				.subscriptionType(subscriptions.getSubscriptionType())
//				.price(subscriptions.getPrice())
//				.planValidity(subscriptions.getPlanValidity())
//				.usersAllowed(subscriptions.getUsersAllowed())
//				.build();
//	}
	
//	int planValidity = 30;
//	SubscriptionService subscriptionService = new SubscriptionService();
//	LocalDate startDate = LocalDate.of(2023, 2, 21);
//	int planValidityDays = 30;
//	LocalDate endDate = subscriptionService.calculateEndDate(startDate, planValidityDays);
//	System.out.println("Subscription end date: " + endDate);

	
	

	
	
	

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
