package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A07_Number_of_Pairs {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            input.readLine();
            int[] left = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] right = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(bruteForcePairs(left, right));
        }
    }

    // number of pairs such that x^y > y^x
    public static long bruteForcePairs(int[] left, int[] right) {
        long pairs = 0;
        for (int i : left) {
            for (int j : right) {
                if (i >= 3 && j >= 3) {
                    if (i < j) {
                        pairs++;
                    }
                } else if (i <= 2 && j <= 2) {
                    if (i > j) {
                        pairs++;
                    }
                } else {
                    if (i == 3 && j == 2) {
                        pairs++;
                    } else if (i == 0 || i == 1 || (i == 2 && j == 3) || (i == 2 && j == 4) || j == 2) {
                        continue;
                    } else {
                        pairs++;
                    }
                }
            }
        }
        return pairs;
    }
}
