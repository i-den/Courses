public class P53_Maximum_Subarray {

    public int maxSubArray(int[] arr) {
        int currMaxSum = 0;
        int globalMaxSum = Integer.MIN_VALUE;

        for (int value : arr) {
            currMaxSum = currMaxSum + value;
            currMaxSum = Math.max(currMaxSum, value);
            globalMaxSum = Math.max(currMaxSum, globalMaxSum);
        }
        return globalMaxSum;
    }
}
