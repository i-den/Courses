package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A13_Reverse_Array_in_Groups {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            int numPairs = Integer.parseInt(input.readLine().split("\\s+")[1]);
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            sortArrInPairs(arr, numPairs);
            printArr(arr);
        }
    }


    private static void sortArrInPairs(int[] arr, int numPairs) {
        for (int i = 0; i < arr.length; i += numPairs) {
            int firstUnsortedIdx = i;
            int lastUnsortedIdx = Math.min(firstUnsortedIdx + numPairs - 1, arr.length - 1);

            while (firstUnsortedIdx < lastUnsortedIdx) {
                int tmp = arr[firstUnsortedIdx];
                arr[firstUnsortedIdx] = arr[lastUnsortedIdx];
                arr[lastUnsortedIdx] = tmp;
                firstUnsortedIdx++;
                lastUnsortedIdx--;
            }
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
