package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A03_Kadanes_Algorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());

        for (int i = 0; i < numCases; i++) {
            input.readLine();
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(kadane(arr));
        }
    }

    public static int kadane(int[] arr) {
        int currMaxSum = 0;
        int globalMaxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currMaxSum = currMaxSum + arr[i];
            currMaxSum = Math.max(currMaxSum, arr[i]);
            globalMaxSum = Math.max(currMaxSum, globalMaxSum);
        }
        return globalMaxSum;
    }
}
