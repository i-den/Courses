package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A20_Convert_Arr_into_Zig_Zag_Fashion {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            int arrLen = Integer.parseInt(input.readLine());
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            zigZag(arr);
            printArr(arr);
        }
    }

    private static void zigZag(int[] arr) {
        boolean leftShouldBeBigger = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (leftShouldBeBigger && arr[i] > arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
            if (!leftShouldBeBigger && arr[i] < arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
            leftShouldBeBigger = !leftShouldBeBigger;
        }
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
