package com.trendyol.javafunctionalprogrammingbootcamp.practices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Practise4Test {

    Practise4 practise;

    @BeforeEach
    void setUp() {
        practise = new Practise4();
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    void orderByLength(List<String> strings, boolean decreasing, List<String> expected) {
        // given

        // when
        List<String> result = practise.orderByLength(strings, decreasing);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(List.of(), true, List.of()),
                Arguments.of(List.of(), false, List.of()),
                Arguments.of(List.of("Trendyol", "Bootcamp", "Java", "Training", "Functional"), true, List.of("Functional", "Trendyol", "Bootcamp", "Training", "Java")),
                Arguments.of(List.of("Trendyol", "Bootcamp", "Java", "Training", "Functional"), false, List.of("Java", "Trendyol", "Bootcamp", "Training", "Functional")),
                Arguments.of(List.of("Gurkan", "Demir", "International", "Payment", "Team"), true, List.of("International", "Payment", "Gurkan", "Demir", "Team")),
                Arguments.of(List.of("Gurkan", "Demir", "International", "Payment", "Team"), false, List.of("Team", "Demir", "Gurkan", "Payment", "International"))
        );
    }
}