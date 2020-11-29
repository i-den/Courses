public class P198_House_Robber {

    public static void main(String[] args) {
        P198_House_Robber solution = new P198_House_Robber();
        int[] arr = {2,7,9,3,1};
        System.out.println(solution.rob(arr));
    }

    public int rob(int[] nums) {
        return 1;
    }

    private class Recursive {
        public int rob(int[] nums) {
            return rec(nums, 0, 0);
        }

        private int rec(int[] nums, int idx, int sum) {
            if(idx >= nums.length) {
                return sum;
            }

            sum = Math.max(
                    nums[idx] + rec(nums, idx + 2, sum),
                    rec(nums, idx + 1, sum)
            );

            return sum;
        }
    }

}
