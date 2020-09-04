package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class A16_Pythagorean_Triplet {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            int arrLen = Integer.parseInt(input.readLine());
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(findTripletsSet(arr));
        }

    }

    private static String findTripletsSet(int[] arr) {
        HashSet<Integer> squaredNums = new HashSet<>(arr.length);
        for (int i : arr) {
            squaredNums.add(i * i);
        }
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int sec = arr[j];
                int squared = (first * first) + (sec * sec);
                if (squaredNums.contains(squared)) {
                    return "Yes";
                }
            }
        }
        return "No";
    }
}