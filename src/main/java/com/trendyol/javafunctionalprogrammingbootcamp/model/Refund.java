package com.trendyol.javafunctionalprogrammingbootcamp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Refund {

    private String id;
    private BigDecimal amount;
    private boolean success;
    private String rawResponse;
}
