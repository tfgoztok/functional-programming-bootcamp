package com.trendyol.javafunctionalprogrammingbootcamp.practices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Practise2Test {

    Practise2 practise;

    @BeforeEach
    void setUp() {
        practise = new Practise2();
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    void filterByFirstCharacter(List<String> strings, char first, List<String> expected) {
        // given

        // when
        List<String> result = practise.filterByFirstCharacter(strings, first);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(List.of("Trendyol", "Bootcamp", "Java", "Training", "Functional"), "t", List.of("Trendyol", "Training")),
                Arguments.of(List.of("Trendyol", "Bootcamp", "Java", "Training", "Functional"), "T", List.of("Trendyol", "Training")),
                Arguments.of(List.of("Trendyol", "Bootcamp", "Java", "Training", "Functional"), "b", List.of("Bootcamp")),
                Arguments.of(List.of("Trendyol", "Bootcamp", "Java", "Training", "Functional"), "j", List.of("Java")),
                Arguments.of(List.of("Trendyol", "Bootcamp", "Java", "Training", "Functional"), "F", List.of("Functional")),
                Arguments.of(List.of("Trendyol", "Bootcamp", "Java", "Training", "Functional"), "G", List.of()),
                Arguments.of(List.of("Trendyol", "Bootcamp", "Java", "Training", "Functional"), "r", List.of())
        );
    }
}