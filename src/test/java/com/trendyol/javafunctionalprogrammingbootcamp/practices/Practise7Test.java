package com.trendyol.javafunctionalprogrammingbootcamp.practices;

import com.trendyol.javafunctionalprogrammingbootcamp.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Practise7Test {

    Practise7 practise;

    @BeforeEach
    void setUp() {
        practise = new Practise7();
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    void isReconciliationCompletedForGivenDateRange(List<Payment> payments, Long startDate, Long endDate, boolean expected) {
        // given

        // when
        boolean result = practise.isReconciliationCompletedForGivenDateRange(payments, startDate, endDate);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(List.of(), 1L, 2L, true),
                Arguments.of(List.of(preparePayment("1", 2L, true)), 1L, 3L, true),
                Arguments.of(List.of(preparePayment("1", 2L, false)), 1L, 3L, false),
                Arguments.of(List.of(
                        preparePayment("1", 4L, true),
                        preparePayment("2", 5L, true)), 1L, 3L, true),
                Arguments.of(List.of(
                        preparePayment("1", 4L, true),
                        preparePayment("2", 5L, false)), 3L, 6L, false),
                Arguments.of(List.of(
                        preparePayment("1", 4L, true),
                        preparePayment("2", 5L, true)), 3L, 6L, true),
                Arguments.of(List.of(
                        preparePayment("1", 2L, false),
                        preparePayment("2", 5L, true),
                        preparePayment("3", 6L, true)), 3L, 6L, true),
                Arguments.of(List.of(
                        preparePayment("1", 3L, true),
                        preparePayment("2", 5L, true),
                        preparePayment("3", 7L, false)), 3L, 6L, true)

        );
    }

    private static Payment preparePayment(String id, Long createdDate, boolean reconciliationCompleted) {
        return Payment.builder()
                .id(id)
                .createdDate(createdDate)
                .amount(BigDecimal.ONE)
                .reconciliationCompleted(reconciliationCompleted)
                .build();
    }
}
