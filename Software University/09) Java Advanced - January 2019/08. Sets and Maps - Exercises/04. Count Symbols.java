import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> symbolOccurrences = new TreeMap<>();

        char[] inputChars = scanner.nextLine().toCharArray();
        for (char inputChar : inputChars) {
            symbolOccurrences.putIfAbsent(inputChar, 0);
            symbolOccurrences.put(
                    inputChar,
                    symbolOccurrences.get(inputChar) + 1
            );
        }

        for (Character currChar : symbolOccurrences.keySet()) {
            System.out.printf("%s: %d time/s%s", currChar, symbolOccurrences.get(currChar), System.lineSeparator());
        }
    }
}