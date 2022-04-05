package gul.trunk;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DailySwappingNodesInALinkedListTest {

    @ParameterizedTest
    @MethodSource("args")
    public void replacesKElementFromBeginningWithKElementFromEnd(ListNode input, int k, ListNode expected) {
        System.out.println("Input:    " + toString(input));
        var output = new DailySwappingNodesInALinkedList().swapNodes(input, k);

        System.out.println("Expected: " + toString(expected));
        System.out.println("Output:   " + toString(output));
        assertEquals(ToList(expected), ToList(output));
    }

    public static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(ToListNode(new int[]{1, 2}), 2, ToListNode(new int[]{2, 1})),
                Arguments.of(ToListNode(new int[]{100, 24, 24, 36, 18, 52, 95, 61, 54, 88, 86, 79, 11, 1, 31, 26}), 16, ToListNode(new int[]{26, 24, 24, 36, 18, 52, 95, 61, 54, 88, 86, 79, 11, 1, 31, 100})),
                Arguments.of(ToListNode(new int[]{1, 2, 3, 4, 5, 6, 7}), 2, ToListNode(new int[]{1, 6, 3, 4, 5, 2, 7})),
                Arguments.of(ToListNode(new int[]{1, 2, 3, 4, 5, 6, 7}), 1, ToListNode(new int[]{7, 2, 3, 4, 5, 6, 1})),
                Arguments.of(ToListNode(new int[]{1, 2, 3, 4, 5, 6, 7}), 5, ToListNode(new int[]{1, 2, 5, 4, 3, 6, 7})),
                Arguments.of(ToListNode(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}), 5, ToListNode(new int[]{7, 9, 6, 6, 8, 7, 3, 0, 9, 5})),
                Arguments.of(ToListNode(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}), 6, ToListNode(new int[]{7, 9, 6, 6, 8, 7, 3, 0, 9, 5}))
        );
    }

    private static String toString(ListNode node) {
        var result = new LinkedList<Integer>();
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        return result.stream().map(it -> {
            return "" + it;
        }).collect(Collectors.joining(", "));
    }

    private static List<Integer> ToList(ListNode node) {
        var result = new LinkedList<Integer>();
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        return result;
    }

    private static ListNode ToListNode(int[] values) {
        final ListNode[] prev = {null};
        final ListNode[] first = {null};
        Arrays.stream(values).forEach(it -> {
            var node = new ListNode(it);
            if (first[0] == null) {
                first[0] = node;
            }
            if (prev[0] != null) {
                prev[0].next = node;
            }
            prev[0] = node;
        });
        return first[0];
    }
}