package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A17_Choco_Indian_Guys_Retarded_Attempt_at_a_Problem {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            int arrLen = Integer.parseInt(input.readLine());
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int studentCnt = Integer.parseInt(input.readLine());
            System.out.println(minSubArrDiff(arr, studentCnt));
        }
    }

    private static int minSubArrDiff(int[] arr, int n) {
        Arrays.sort(arr);
        int minSum = Integer.MAX_VALUE;
        for (int i = n - 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i -n + 1];
            minSum = Integer.min(minSum, diff);
        }
        return minSum;
    }

}
