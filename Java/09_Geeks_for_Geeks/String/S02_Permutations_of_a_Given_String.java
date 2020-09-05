package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S02_Permutations_of_a_Given_String {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String strToGetPermutationsOf = input.readLine();
            getPermutations(strToGetPermutationsOf);
        }
    }

    private static void getPermutations(String strToGetPermutationsOf) {
        List<String> permutations = new ArrayList<>();
        permutate("", strToGetPermutationsOf, permutations);
        printPermutations(permutations);
    }

    private static void permutate(String currPermutation, String string, List<String> permutations) {
        if (string.isEmpty()) {
            permutations.add(currPermutation + string);
        }
        for (int i = 0; i < string.length(); i++) {
            permutate(
                    currPermutation + string.charAt(i),
                    string.substring(0, i) + string.substring(i + 1),
                    permutations
            );
        }
    }

    private static void printPermutations(List<String> permutations) {
        Collections.sort(permutations);
        System.out.println(String.join(" ", permutations));
    }
}
