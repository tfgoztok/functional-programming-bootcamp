package com.trendyol.javafunctionalprogrammingbootcamp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class SavedPaypalAccount {

    private String id;
    private boolean active;
    private String paypalCustomerEmail;
    private String paypalCustomerId;
    private Long createdDate;
}
