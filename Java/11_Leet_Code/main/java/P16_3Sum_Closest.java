import java.util.Arrays;

public class P16_3Sum_Closest {

    public int threeSumClosest(int[] nums, int target) {
        int minDifference = Integer.MAX_VALUE;
        int sumWithMinDifference = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;
                if (sum == target) {
                    return sum;
                }
                int diff = Math.abs(target - sum);
                if (diff < minDifference) {
                    minDifference = diff;
                    sumWithMinDifference = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return sumWithMinDifference;
    }

    public int threeSumBruteForce(int[] nums, int target) {
        int minDifference = Integer.MAX_VALUE;
        int sumWithMinDiff = 0;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    int sum = a + b + c;
                    int difference = Math.abs(target - sum);
                    if (difference < minDifference) {
                        minDifference = difference;
                        sumWithMinDiff = sum;
                    }
                }
            }
        }

        return sumWithMinDiff;
    }
}
