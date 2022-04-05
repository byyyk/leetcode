package gul.trunk;

public class BinarySearch704 {
    public int search(int[] nums, int target) {
        var down = 0;
        var up = nums.length - 1;
        if (nums[down] == target) {
            return down;
        }
        if (nums[up] == target) {
            return up;
        }
        do {
            var index = (up + down) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] < target) {
                down = index;
            } else {
                up = index;
            }
        } while (up - down > 1);

        return -1;
    }
}
