import java.util.HashMap;

public class P01_Two_Sum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> precomputedNums = new HashMap<>(nums.length);
        precomputedNums.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int difference = target - nums[i];
            if (precomputedNums.containsKey(difference)) {
                return new int[]{precomputedNums.get(difference), i};
            }
            precomputedNums.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
