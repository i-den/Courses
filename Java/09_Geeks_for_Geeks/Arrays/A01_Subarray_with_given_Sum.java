package GeeksForGeeks.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class A01_Subarray_with_given_Sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfCases = Integer.parseInt(input.nextLine());

        for (int i = 0; i < numOfCases; i++) {
            String[] arrSizeAndTargetSumLine = input.nextLine().split("\\s+");
            int arrSize = Integer.parseInt(arrSizeAndTargetSumLine[0]); // ¯\_(ツ)_/¯
            long targetSum = Long.parseLong(arrSizeAndTargetSumLine[1]);

            long[] arr = Arrays.stream(input.nextLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
            slide(arr, targetSum);
        }
    }

    private static void slide(long[] arr, long targetSum) {
        long currSum = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        while (rightIdx < arr.length) {
            if (currSum < targetSum) {
                currSum += arr[rightIdx];
                rightIdx++;
            }
            while ((currSum > targetSum) && leftIdx < rightIdx) {
                currSum -= arr[leftIdx];
                leftIdx++;
            }
            if (currSum == targetSum) {
                System.out.println((leftIdx + 1) + " " + (rightIdx));
                return;
            }
        }
        System.out.println(-1);
    }
}
