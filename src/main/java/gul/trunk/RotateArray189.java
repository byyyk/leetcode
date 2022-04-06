package gul.trunk;

// https://leetcode.com/problems/rotate-array/
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0 || nums.length <= 1) {
            return;
        }

        var j = 0;
        var tmp = nums[nums.length - k];
        for (int i = 0; i < nums.length; i++) {
//            System.out.println(String.format("j = %d", j));
//            System.out.println(String.format("tmp = %d", tmp));
//            ArrayUtils.print(nums);
            var nextTmp = nums[j];
            nums[j] = tmp;
            tmp = nextTmp;
            j += k;

            j = j % nums.length;
            if (i < nums.length - 1 && j < k && nums.length % k == 0) {
                j++;
                tmp = nums[nums.length - (k - j)];
            }
        }
//        ArrayUtils.print(nums);
    }

    public static void main(String[] args) {
//        new RotateArray189().rotate(new int[] {-1,-100,3,99}, 2);
        new RotateArray189().rotate(new int[] {0, 1, 2, 3, 4 ,5 , 6 ,7, 8}, 3);
    }
}


