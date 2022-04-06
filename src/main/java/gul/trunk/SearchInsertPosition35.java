package gul.trunk;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        var down = 0;
        var up = nums.length - 1;

        while (down <= up) {
            var index = (down + up) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] < target) {
                down = index + 1;
            } else {
                up = index - 1;
            }
        }

        if (target > up) {
            return up + 1;
        } else {
            return down;
        }
    }
}
