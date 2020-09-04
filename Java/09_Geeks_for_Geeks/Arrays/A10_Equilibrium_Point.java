package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A10_Equilibrium_Point {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            input.readLine();
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getEquilibrium(arr));
        }
    }

    private static int getEquilibrium(int[] arr) {
        if (arr.length == 1)
            return 1;

        int leftSum = 0;
        int rightSum = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            rightSum += arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            leftSum += arr[i - 1];
            int tempRightSum = rightSum - arr[i - 1] - arr[i];
            if (leftSum == tempRightSum) {
                return i + 1;
            }
            rightSum -= arr[i - 1];
        }

        return -1;
    }
}
