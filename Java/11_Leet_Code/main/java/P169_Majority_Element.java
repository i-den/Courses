import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P169_Majority_Element {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        int n = nums.length / 2;
        Arrays.sort(nums);

        int maxCnt = 0;
        int numMaxCnt = 0;

        int idx = 0;
        while(idx < nums.length) {
            boolean iterated = false;
            int currNum = nums[idx];
            int currNumMax = 0;

            // lookup last
            if(currNum == nums[nums.length - 1]) {
                currNumMax = nums.length - idx;
                if(currNumMax > maxCnt)
                    return currNum;
            }

            while(idx < nums.length && currNum == nums[idx]) {
                iterated = true;
                currNumMax++;
                if(currNumMax > maxCnt) {
                    if(currNumMax > n) {
                        return currNum;
                    }
                    maxCnt = currNumMax;
                    numMaxCnt = currNum;
                }
                idx++;
            }

            if(!iterated)
                idx++;
        }

        return numMaxCnt;
    }

    public int majorityElement3(int[] nums) {
        int n = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            int cnt = map.get(nums[i]) + 1;

            if(cnt > n) {
                return nums[i];
            }

            map.put(nums[i], cnt);
        }

        return -1;
    }
}
