package GeeksForGeeks.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A02_Count_the_Triplets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = Integer.parseInt(input.nextLine());

        for (int i = 0; i < numCases; i++) {
            int arrLen = Integer.parseInt(input.nextLine().trim());
            if (arrLen < 3) {
                input.nextLine();
                System.out.println(-1);
                continue;
            }

            Long[] arr = Arrays.stream(input.nextLine().split("\\s+")).map(Long::valueOf).toArray(Long[]::new);
            System.out.println(sortPivots(arr));
        }
    }

    private static int bruteForceWithSet(Long[] arr) {
        Set<Long> previousNums = new HashSet<>(Arrays.asList(arr));
        int numTriplets = 0;
        for (int i = 0; i < arr.length; i++) {
            long a = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                long b = arr[j];
                long sum = a + b;

                if (previousNums.contains(sum)) {
                    numTriplets++;
                }
            }
        }
        return numTriplets > 0 ? numTriplets : -1;
    }

    // 1 2 3 4 5 7 8 9
    private static int sortPivots(Long[] arr) {
        Arrays.sort(arr);
        int numTriplets = 0;
        int currEle = arr.length - 1;
        int left = 0;
        int right = currEle - 1;

        while (currEle >= 0) {
            while (left < right) {
                long currSum = arr[left] + arr[right];
                if (currSum == arr[currEle]) {
                    numTriplets++;
                    left++;
                    right--;
                } else if (currSum > arr[currEle]) {
                    right--;
                } else {
                    left++;
                }
            }
            currEle--;
            left = 0;
            right = currEle - 1;
        }
        return numTriplets > 0 ? numTriplets : -1;
    }
}
