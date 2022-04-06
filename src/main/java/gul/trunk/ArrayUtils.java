package gul.trunk;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayUtils {
    public static void print(int[] array) {
        System.out.println(Arrays.stream(array).mapToObj(it -> "" + it).collect(Collectors.joining(", ")));
    }
}
