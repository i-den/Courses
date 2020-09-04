package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A21_Last_Index_of_One { // ????
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            String line = input.readLine();
            System.out.println(lastIdxOfOne(line));
        }
    }

    private static int lastIdxOfOne(String line) {
        return line.lastIndexOf('1');
    }
}
