package gul.trunk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchInsertPosition35Test {
    @ParameterizedTest
    @MethodSource("args")
    void numberIsFoundInSortedArray(int[] input, int searched, int expectedIndex) {
        var algo = new SearchInsertPosition35();
        var result = algo.searchInsert(input, searched);
        Assertions.assertEquals(expectedIndex, result);
    }

    static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[] {1, 3, 5, 6}, 2, 1),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666, 777}, 100, 3),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666, 777}, 2, 2),
                Arguments.of(new int[] {-1, 0, 3, 100, 230, 666, 777}, 778, 7)
        );
    }
}