public class P34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearchLeftIdx(nums, target);
        if(leftIdx == -1) {
            return new int[]{-1, -1};
        }
        int rightIdx = binarySearchRightIdx(nums, leftIdx, target);
        return new int[]{leftIdx, rightIdx};
    }

    public int binarySearchLeftIdx(int[] nums, int target) {
        int leftIdx = Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                leftIdx = Math.min(leftIdx, mid);
            }

            if(nums[mid] >= target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return leftIdx == Integer.MAX_VALUE ? -1 : leftIdx;
    }

    public int binarySearchRightIdx(int[] nums, int start, int target) {
        int rightIdx = start;

        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                rightIdx = Math.max(rightIdx, mid);
            }

            if(nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] <= target) {
                start = mid + 1;
            }
        }
        return rightIdx;
    }
}
