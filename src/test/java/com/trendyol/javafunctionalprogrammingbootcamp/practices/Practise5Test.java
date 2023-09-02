package com.trendyol.javafunctionalprogrammingbootcamp.practices;

import com.trendyol.javafunctionalprogrammingbootcamp.model.Refund;
import com.trendyol.javafunctionalprogrammingbootcamp.model.RefundDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Practise5Test {

    Practise5 practise;

    @BeforeEach
    void setUp() {
        practise = new Practise5();
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    void assembleSuccessfulRefunds(List<Refund> refunds, List<RefundDto> expected) {
        // given

        // when
        List<RefundDto> result = practise.assembleSuccessfulRefunds(refunds);

        // then
        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            RefundDto refundDto = expected.get(i);
            assertEquals(refundDto.getId(), result.get(i).getId());
        }
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of(List.of(), List.of()),
                Arguments.of(
                        List.of(
                                prepareRefund("1", false),
                                prepareRefund("2", true)
                        ),
                        List.of(
                                prepareRefundDto("2")
                        )
                ),
                Arguments.of(
                        List.of(
                                prepareRefund("1", false),
                                prepareRefund("2", false)
                        ),
                        List.of()
                ),
                Arguments.of(
                        List.of(
                                prepareRefund("1", true),
                                prepareRefund("2", true)
                        ),
                        List.of(
                                prepareRefundDto("1"),
                                prepareRefundDto("2")
                        )
                )
        );
    }

    private static Refund prepareRefund(String id, boolean success) {
        return Refund.builder()
                .id(id)
                .amount(BigDecimal.ONE)
                .success(success)
                .rawResponse("rawResponse")
                .build();
    }

    private static RefundDto prepareRefundDto(String id) {
        return RefundDto.builder()
                .id(id)
                .build();
    }
}