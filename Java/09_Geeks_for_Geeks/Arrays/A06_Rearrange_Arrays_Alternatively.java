package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A06_Rearrange_Arrays_Alternatively {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            input.readLine();
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            printArr(rearrangeArrAlt(arr));
        }
    }

    public static int[] rearrangeArrAlt(int[] arr) {
        int[] rearranged = new int[arr.length];
        int rearrangedPtr = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            rearranged[rearrangedPtr++] = arr[arr.length - i - 1];
            rearranged[rearrangedPtr++] = arr[i];
        }
        if (arr.length % 2 != 0) {
            rearranged[rearrangedPtr] = arr[arr.length / 2];
        }
        return rearranged;
    }

    private static void printArr(int[] arr) {
        StringBuilder arrEles = new StringBuilder();
        for (int i : arr) {
            arrEles.append(i);
            arrEles.append(" ");
        }
        System.out.println(arrEles.toString().trim());
    }
}
