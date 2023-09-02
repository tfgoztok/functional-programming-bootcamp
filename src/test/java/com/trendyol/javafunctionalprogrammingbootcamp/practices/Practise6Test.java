package com.trendyol.javafunctionalprogrammingbootcamp.practices;

import com.trendyol.javafunctionalprogrammingbootcamp.exceptions.NotFoundException;
import com.trendyol.javafunctionalprogrammingbootcamp.model.SavedPaypalAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Practise6Test {

    Practise6 practise;

    @BeforeEach
    void setUp() {
        practise = new Practise6();
    }

    @ParameterizedTest
    @MethodSource(value = "inputsForSuccessCases")
    void getFirstActiveSavedPaypalAccount(List<SavedPaypalAccount> savedPaypalAccounts, int expectedIndex) {
        // given

        // when
        SavedPaypalAccount result = practise.getFirstActiveSavedPaypalAccount(savedPaypalAccounts);

        // then
        assertEquals(savedPaypalAccounts.get(expectedIndex), result);
    }

    @ParameterizedTest
    @MethodSource(value = "inputsForFailureCases")
    void getFirstActiveSavedPaypalAccountThrowsException(List<SavedPaypalAccount> savedPaypalAccounts) {
        // given

        // verify
        assertThrows(NotFoundException.class, () -> practise.getFirstActiveSavedPaypalAccount(savedPaypalAccounts));
    }

    private static Stream<Arguments> inputsForSuccessCases() {
        return Stream.of(
                Arguments.of(List.of(prepareSavedPaypalAccount("1", true)), 0),
                Arguments.of(List.of(
                        prepareSavedPaypalAccount("1", true),
                        prepareSavedPaypalAccount("2", false)), 0),
                Arguments.of(List.of(
                        prepareSavedPaypalAccount("1", false),
                        prepareSavedPaypalAccount("2", true)), 1),
                Arguments.of(List.of(
                        prepareSavedPaypalAccount("1", true),
                        prepareSavedPaypalAccount("2", false),
                        prepareSavedPaypalAccount("3", true)), 0)
        );
    }

    private static Stream<Arguments> inputsForFailureCases() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(prepareSavedPaypalAccount("1", false))),
                Arguments.of(List.of(
                        prepareSavedPaypalAccount("1", false),
                        prepareSavedPaypalAccount("2", false))),
                Arguments.of(List.of(
                        prepareSavedPaypalAccount("1", false),
                        prepareSavedPaypalAccount("2", false),
                        prepareSavedPaypalAccount("3", false)))
        );
    }

    private static SavedPaypalAccount prepareSavedPaypalAccount(String id, boolean active) {
        return SavedPaypalAccount.builder()
                .id(id)
                .active(active)
                .paypalCustomerId("paypalCustomerId")
                .createdDate(1L)
                .build();
    }
}
