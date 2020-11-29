public class P704_Binary_Search {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] <  target) {
                start = start + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int searchRec(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch(arr, target, start, mid - 1);
        }
        return binarySearch(arr, target, mid + 1, end);
    }
}
