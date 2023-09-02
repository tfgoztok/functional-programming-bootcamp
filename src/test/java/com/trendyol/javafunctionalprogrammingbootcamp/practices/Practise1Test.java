package com.trendyol.javafunctionalprogrammingbootcamp.practices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Practise1Test {

    Practise1 practise;

    @BeforeEach
    void setUp() {
        practise = new Practise1();
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    void returnEvenNumbers(List<Integer> numbers, List<Integer> expected) {
        // given

        // when
        List<Integer> result = practise.returnEvenNumbers(numbers);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(1), List.of()),
                Arguments.of(List.of(2), List.of(2)),
                Arguments.of(List.of(1, 2), List.of(2)),
                Arguments.of(List.of(1, 2, 3, 4), List.of(2, 4)),
                Arguments.of(List.of(2, 4, 6, 8), List.of(2, 4, 6, 8))
        );
    }
}