package gul.trunk;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray977 {

    public int[] sortedSquares(int[] nums) {
        var result = new int[nums.length];
        var j = nums.length - 1;
        var i = 0;

        while(i <= j) {
            var left = nums[i];
            var right = nums[j];

            left *= left;
            right *= right;

            if (left > right) {
                result[j - i] = left;
                i++;
            } else {
                result[j - i] = right;
                j--;
            }
        }

        return result;
    }
}
