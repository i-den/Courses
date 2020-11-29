import java.util.HashSet;
import java.util.Set;

public class P55_Jump_Game {

    public boolean greedyBack(int[] nums) {
        int idx = nums.length - 1;
        for(int i = idx; i >= 0; i--) {
            int maxPossibleJump = nums[i] + i;
            if(maxPossibleJump >= idx) {
                idx = i;
            }
        }
        return idx == 0;
    }


    public boolean greedyForward(int[] nums) {
        int maxReachableIdx = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > maxReachableIdx) {
                return false;
            }

            int maxIdxAfterJump = i + nums[i];
            if( maxIdxAfterJump >= (nums.length - 1)  ) {
                return true;
            }

            maxReachableIdx = Math.max(maxReachableIdx, maxIdxAfterJump);
        }

        return false;
    }


    private class Backtracking {
        Set<Integer> faultyIdxs = new HashSet<>();


        public boolean jump(int[] nums, int idx) {
            if(idx == nums.length - 1)
                return true;

            if(faultyIdxs.contains(idx))
                return false;

            int maxPossibleJump = Math.min(nums.length - 1, nums[idx] + idx);
            for(int i = idx + 1; i <= maxPossibleJump; i++) {
                if(jump(nums, i))
                    return true;
            }

            faultyIdxs.add(idx);
            return false;
        }
    }
}
