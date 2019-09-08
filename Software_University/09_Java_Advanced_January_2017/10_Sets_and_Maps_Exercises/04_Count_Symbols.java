import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> charOccurrences = new TreeMap<>();

        char[] chars = scanner.nextLine()
                .toCharArray();

        for (char currChar : chars) {
            if (!charOccurrences.containsKey(currChar)) {
                charOccurrences.put(currChar, 0);
            }

            charOccurrences.put(currChar, charOccurrences.get(currChar) + 1);
        }

        for (Character currCharKey : charOccurrences.keySet()) {
            System.out.println(currCharKey + ": " + charOccurrences.get(currCharKey) + " time/s");
        }
    }
}