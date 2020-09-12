import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P15_3Sum {

    public List<List<Integer>> threeSums(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> tripletsThatAmountTo0 = new ArrayList<>(nums.length / 3);

        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            if (i > 0 && a == nums[i - 1])
                continue;

            int leftPtr = i + 1;
            int rightPtr = nums.length - 1;
            while (leftPtr < rightPtr) {
                int b = nums[leftPtr];
                int c = nums[rightPtr];
                int sum = a + b + c;
                if (sum == 0) {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(a);
                    triplets.add(b);
                    triplets.add(c);
                    tripletsThatAmountTo0.add(triplets);

                    leftPtr++;
                    while (nums[leftPtr] == nums[leftPtr - 1] && leftPtr < rightPtr) {
                        leftPtr++;
                    }
                } else if (sum > 0) {
                    rightPtr--;
                } else {
                    leftPtr++;
                }
            }
        }

        return tripletsThatAmountTo0;
    }

    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Set<List<Integer>> sumTriplets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];

                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];

                    if (a + b + c == 0) {
                        List<Integer> arr = new ArrayList<>(3);
                        arr.add(a);
                        arr.add(b);
                        arr.add(c);
                        Collections.sort(arr);
                        sumTriplets.add(arr);
                    }
                }
            }
        }
        return new ArrayList<>(sumTriplets);
    }
}
