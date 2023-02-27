package com.rendShow.customerService.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionDto {
    private String email;
    private String subscriptionType;
    private BigDecimal price;
    private Integer usersAllowed ;
    private Integer planValidity ;

}
