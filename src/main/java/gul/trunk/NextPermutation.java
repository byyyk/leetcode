package gul.trunk;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int candidate = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && (candidate == -1 || nums[j] < nums[candidate])) {
                    candidate = j;
                }
            }
            if (candidate != -1) {
                switchDigits(nums, candidate, i);

                int switches;
                do {
                    switches = 0;
                    for (int j = i + 1; j < nums.length - 1; j++) {
                        if (nums[j] > nums[j + 1]) {
                            switchDigits(nums, j, j + 1);
                            switches++;
                        }
                    }
                } while (switches != 0);
                return;
            }
        }

        for (int i = 0; i <= (nums.length / 2) - 1; i++) {
            switchDigits(nums, i, nums.length - 1 - i);
        }
    }

    private void switchDigits(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
