public class P27_Remove_Element {

    public int removeElement(int[] nums, int val) {
        int n = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 0;
            } else {
                n++;
                nums[idx++] = nums[i];
            }
        }
        return n;
    }
}
