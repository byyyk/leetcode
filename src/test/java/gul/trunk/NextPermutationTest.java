package gul.trunk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NextPermutationTest {

    @ParameterizedTest
    @MethodSource("args")
    void shouldFindNextPermutation(int[] nums, int[] expected) {
        new NextPermutation().nextPermutation(nums);

        Assertions.assertEquals(nums.length, expected.length);
        for (int i = 0; i < nums.length; i++) {
            Assertions.assertEquals(expected[i], nums[i], String.format("Value mismatch at index %d", i));
        }
    }

    public Stream<Arguments> args() {
        return Stream.of(
            Arguments.of(new int[] {1, 5, 3, 3, 5, 4}, new int[] {1, 5, 3, 4, 3, 5}),
            Arguments.of(new int[] {1, 5, 3, 2}, new int[] {2, 1, 3, 5}),
            Arguments.of(new int[] {1, 3, 2}, new int[] {2, 1, 3}),
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {1, 2, 4, 3}),
            Arguments.of(new int[] {1, 3, 1, 1}, new int[] {3, 1, 1, 1}),
            Arguments.of(new int[] {4, 1, 2, 1, 1}, new int[] {4, 2, 1, 1, 1}),
            Arguments.of(new int[] {4, 1, 2, 3, 1}, new int[] {4, 1, 3, 1, 2}),
            Arguments.of(new int[] {3, 2, 1, 1}, new int[] {1, 1, 2, 3}),
            Arguments.of(new int[] {4, 3, 2, 1, 1}, new int[] {1, 1, 2, 3, 4})
        );
    }
}