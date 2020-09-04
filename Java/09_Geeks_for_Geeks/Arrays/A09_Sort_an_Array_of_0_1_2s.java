package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A09_Sort_an_Array_of_0_1_2s {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            input.readLine();
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);
            printArr(arr);
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
