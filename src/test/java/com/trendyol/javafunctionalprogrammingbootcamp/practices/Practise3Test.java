package com.trendyol.javafunctionalprogrammingbootcamp.practices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Practise3Test {

    Practise3 practise;

    @BeforeEach
    void setUp() {
        practise = new Practise3();
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    void sumsSquares(List<Integer> numbers, int expected) {
        // given

        // when
        int result = practise.sumsSquares(numbers);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(List.of(), 0),
                Arguments.of(List.of(0), 0),
                Arguments.of(List.of(0, 1, 2), 5),
                Arguments.of(List.of(2, 4, 6), 56),
                Arguments.of(List.of(3, 9), 90),
                Arguments.of(List.of(10, 100), 10100)
        );
    }
}