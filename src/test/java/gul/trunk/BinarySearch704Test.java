package gul.trunk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

class BinarySearch704Test {
    @ParameterizedTest
    @MethodSource("args")
    void numberIsFoundInSortedArray(int[] input, int searched, int expectedIndex) {
        var binarySearch = new BinarySearch704();
        var result = binarySearch.search(input, searched);
        Assertions.assertEquals(expectedIndex, result);
    }

    static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[] {6}, 6, 0),
                Arguments.of(new int[] {6}, 7, -1),
                Arguments.of(new int[] {-1, 0}, -1, 0),
                Arguments.of(new int[] {-1, 0}, 0, 1),
                Arguments.of(new int[] {-1, 0}, 6, -1),
                Arguments.of(new int[] {-1, 0, 3}, -1, 0),
                Arguments.of(new int[] {-1, 0, 3}, 0, 1),
                Arguments.of(new int[] {-1, 0, 3}, 3, 2),
                Arguments.of(new int[] {-1, 0, 3, 4}, -1, 0),
                Arguments.of(new int[] {-1, 0, 3, 4}, 0, 1),
                Arguments.of(new int[] {-1, 0, 3, 4}, 3, 2),
                Arguments.of(new int[] {-1, 0, 3, 4}, 4, 3),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666}, -1, 0),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666}, 0, 1),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666}, 3, 2),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666}, 100, 3),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666}, 230, 4),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666}, 666, 5),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666, 777}, -1, 0),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666, 777}, 0, 1),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666, 777}, 3, 2),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666, 777}, 100, 3),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666, 777}, 230, 4),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666, 777}, 666, 5),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666, 777}, 777, 6)
        );
    }
}