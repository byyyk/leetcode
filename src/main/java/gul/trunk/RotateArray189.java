package gul.trunk;

// https://leetcode.com/problems/rotate-array/
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0 || nums.length <= 1) {
            return;
        }

        int j = 0, jNormalized = 0;
        var tmp = nums[nums.length - k];
        var offset = 0;
        for (int i = 0; i < nums.length; i++) {
//            System.out.println(String.format("j = %d", j));
//            System.out.println(String.format("jNormalized = %d", jNormalized));
//            System.out.println(String.format("tmp = %d", tmp));
//            ArrayUtils.print(nums);

            var nextTmp = nums[j];
            nums[j] = tmp;
//            ArrayUtils.print(nums);
            tmp = nextTmp;
            j += k;

            j = j % nums.length;
            if (i > 0 && i < nums.length - 1 && j % nums.length == offset) {
                offset++;
                j++;
//                jNormalized = j % nums.length;
                tmp = nums[nums.length - (k - j)];
            }
        }
//        ArrayUtils.print(nums);
    }

    public static void main(String[] args) {
//        new RotateArray189().rotate(new int[] {-1,-100,3,99}, 2);
//        new RotateArray189().rotate(new int[] {0, 1, 2, 3, 4 ,5 , 6 ,7, 8}, 3);
        new RotateArray189().rotate(new int[] {0, 1, 2, 3, 4, 5}, 3);
//        new RotateArray189().rotate(new int[] {1, 2}, 1);
//        new RotateArray189().rotate(new int[] {1, 2, 3, 4, 5, 6}, 4);
    }
}


