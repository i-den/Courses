import java.util.Arrays;

public class P26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        int idx = 1;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == prev) {
                continue;
            } else {
                nums[idx++] = nums[i];
                prev = nums[i];
            }
        }
        return idx;
    }
}
