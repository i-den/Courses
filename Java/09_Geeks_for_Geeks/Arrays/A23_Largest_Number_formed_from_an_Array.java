package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class A23_Largest_Number_formed_from_an_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            int arrLen = Integer.parseInt(input.readLine());
            String[] arr = input.readLine().split("\\s+");
            Arrays.sort(arr, comparator);
            printArr(arr);
        }
    }

    private static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo((o1 + o2));
        }
    };

    private static void printArr(String[] arr) {
        StringBuilder arrEles = new StringBuilder();
        for (String i : arr) {
            arrEles.append(i);
        }
        System.out.println(arrEles.toString().trim());
    }
}
