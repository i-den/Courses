package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A18_Stock_Buy_and_Sell {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            int arrLen = Integer.parseInt(input.readLine());
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(findStocks(arr));
        }
    }

    private static String findStocks(int[] arr) {
        String stocks = "";

        int lastMinIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            int prev = arr[i - 1];
            int curr = arr[i];
            if (prev > curr) {
                if (lastMinIdx != (i - 1)) {
                    stocks += "(" + lastMinIdx + " " + (i - 1) + ") ";
                }
                lastMinIdx = i;
            }
            if ((prev < curr && (i == arr.length - 1))) {
                stocks += "(" + lastMinIdx + " " + (i) + ") ";
            }
        }

        return stocks.length() > 0 ? stocks : "No Profit";
    }
}
