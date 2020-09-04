package GeeksForGeeks.Arrays;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class A04_Missing_Num_in_Array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = Integer.parseInt(input.nextLine());

        for (int i = 0; i < numCases; i++) {
            int maxNums = Integer.parseInt(input.nextLine());
            int[] arr = Arrays.stream(input.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(bitSet(arr, maxNums));
        }
    }

    private static int bruteForce(int[] arr, int maxNums) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != (i + 1))
                return arr[i] - 1;
        }
        return maxNums;
    }

    private static int gaussian(int[] arr, int maxNums) {
        int fullArrSum = maxNums * (maxNums + 1) / 2;
        int arrSum = 0;
        for (int value : arr) {
            arrSum += value;
        }
        return fullArrSum - arrSum;
    }

    private static int bitSet(int[] arr, int maxNums) {
        BitSet bits = new BitSet(arr.length);
        for (int value : arr) {
            bits.set(value - 1);
        }
        return bits.nextClearBit(0) + 1;
    }
}
