package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A19_Element_with_Left_Side_Smaller_and_Right_Side_Greater {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            int arrLen = Integer.parseInt(input.readLine());
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(ele(arr));
        }
    }

    public static int ele(int[] arr) {
        int[] max = new int[arr.length];
        int[] min = new int[arr.length];

        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max[i] = Integer.max(max[i - 1], arr[i]);
        }

        min[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            min[i] = Integer.min(min[i + 1], arr[i]);
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (max[i] == min[i])
                return max[i];
        }

        return -1;
    }
}
