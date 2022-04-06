package gul.trunk;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0, i = 0;
        int tmp = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[zeroIndex] == 0) {
                    nums[zeroIndex] = nums[i];
                    nums[i] = 0;
                }
                zeroIndex++;
            }
        }
    }
}
