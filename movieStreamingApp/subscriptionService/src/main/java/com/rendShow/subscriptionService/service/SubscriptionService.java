package com.rendShow.subscriptionService.service;

import java.time.LocalDate;
import java.util.List;

import com.rendShow.subscriptionService.dto.SubscriptionRequest;
import com.rendShow.subscriptionService.pojo.Subscriptions;

public interface SubscriptionService {
	
	void createSubscription(SubscriptionRequest subscriptionRequest);
//	Subscriptions getSubscriptionById(Long id);
//	List<Subscriptions> getAllSubscriptions();
//	Subscriptions updateSubscription(Subscriptions subscription);
//	void deleteSubscriptionById(Long id);
//	List<Subscriptions> getSubscriptionsByType(String subscriptionType);
//	List<Subscriptions> getSubscriptionsByPriceRange(Double minPrice, Double maxPrice);
//	List<Subscriptions> getSubscriptionsByDateRange(LocalDate startDate, LocalDate endDate);

}
