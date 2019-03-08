package ru.bvpotapenko.se.j3.l6tools;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @DisplayName("Should calculate the correct tail after the last tetrad")
    @ParameterizedTest(name = "{index} => data=''{0}''  expected=''{1}''")
    @MethodSource("getArrTailTestProvider")
    public void getArrTailTest(int[] data, int[] expected) {
        assertEquals(Arrays.toString(expected), Arrays.toString(App.getTailAfterLastTetrad(data)));
    }

    private static Stream<Arguments> getArrTailTestProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 4, 1}, new int[]{1, 4, 1}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{}),
                Arguments.of(new int[]{1, 2, 3, 4, 1, 2, 3}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{1, 2, 3, 4, 1, 2, 3, 4}, new int[]{})
        );
    }

    @DisplayName("Should throw RuntimeException for arrays with less than 4 items")
    @ParameterizedTest(name = "{index} => data=''{0}''")
    @MethodSource("getArrTailTestExceptionProvider")
    public void getArrTailTestException(int[] data) {
        assertThrows(RuntimeException.class, () -> App.getTailAfterLastTetrad(data));
    }

    private static Stream<Arguments> getArrTailTestExceptionProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}),
                Arguments.of(new int[]{1, 2}),
                Arguments.of(new int[]{1,}),
                Arguments.of(new int[]{})
        );
    }

    @DisplayName("Should check the array has at least one 1 and one 4")
    @ParameterizedTest(name = "{index} => data=''{0}'' expected=''{1}''")
    @MethodSource("arrayDummyCheckTestProvider")
    public void arrayDummyCheckTest(int[] data, boolean expected) {
        assertEquals(expected, App.arrayDummyCheck(data));
    }

    private static Stream<Arguments> arrayDummyCheckTestProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 1, 4}, true),
                Arguments.of(new int[]{4, 4, 4}, false),
                Arguments.of(new int[]{1, 1, 1}, false),
                Arguments.of(new int[]{1, 4, 1, 4, 3}, false),
                Arguments.of(new int[]{}, false),
                Arguments.of(new int[]{2, 5, 6}, false)

        );
    }
}
