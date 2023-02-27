package com.rendShow.subscriptionService.service;

import com.rendShow.subscriptionService.dto.SubscriptionDto;
import com.rendShow.subscriptionService.pojo.Subscriptions;

public interface SubscriptionService {
	
	Subscriptions createSubscription(SubscriptionDto subscriptionRequest);
//	Subscriptions getSubscriptionById(Long id);
//	List<Subscriptions> getAllSubscriptions();
//	Subscriptions updateSubscription(Subscriptions subscription);
//	void deleteSubscriptionById(Long id);
//	List<Subscriptions> getSubscriptionsByType(String subscriptionType);
//	List<Subscriptions> getSubscriptionsByPriceRange(Double minPrice, Double maxPrice);
//	List<Subscriptions> getSubscriptionsByDateRange(LocalDate startDate, LocalDate endDate);

}
