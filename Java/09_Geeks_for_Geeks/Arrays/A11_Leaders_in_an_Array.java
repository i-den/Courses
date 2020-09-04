package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A11_Leaders_in_an_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            input.readLine();
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            arrLeaders(arr);
        }
    }

    private static void arrLeaders(int[] arr) {
        int currLargest = arr[arr.length - 1];
        StringBuilder leaders = new StringBuilder(arr.length);
        leaders.insert(0, arr[arr.length - 1]);
        leaders.insert(0, " ");
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= currLargest) {
                leaders.insert(0, arr[i]);
                leaders.insert(0, " ");
                currLargest = arr[i];
            }
        }
        System.out.println(leaders.toString().trim());
    }
}
