package com.rendShow.customerService.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionDto {
    private BigDecimal price;
    private String subscriptionType;
    private String email;
}
