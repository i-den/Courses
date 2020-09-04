package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A15_Trapping_Rain_Water {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            int arrLen = Integer.parseInt(input.readLine());
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(trappedRainWater(arr));
        }
    }

    private static int trappedRainWater(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int accumulatedWater = 0;
        int leftIdx = 0;
        int rightIdx = arr.length - 1;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];

        while (leftIdx < rightIdx) {
            leftMax = Integer.max(leftMax, arr[leftIdx]);
            rightMax = Integer.max(rightMax, arr[rightIdx]);

            if (leftMax <= rightMax) {
                accumulatedWater += (leftMax - arr[leftIdx]);
                leftIdx++;
            } else if (rightMax <= leftMax) {
                accumulatedWater += (rightMax - arr[rightIdx]);
                rightIdx--;
            }
        }

        return accumulatedWater;
    }

    private static int trappedRainWaterBruteForce(int[] arr) {
        int accumulatedWater = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int leftMaxHeight = 0;
            int rightMaxHeight = 0;
            for (int j = 0; j < i; j++) {
                leftMaxHeight = Math.max(leftMaxHeight, arr[j]);
            }
            for (int j = i + 1; j < arr.length; j++) {
                rightMaxHeight = Math.max(rightMaxHeight, arr[j]);
            }
            accumulatedWater += Math.max(Math.min(leftMaxHeight, rightMaxHeight) - arr[i], 0);
        }
        return accumulatedWater;
    }
}
