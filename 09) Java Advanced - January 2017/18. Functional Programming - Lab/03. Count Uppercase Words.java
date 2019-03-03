import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class CntUppercaseWords {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Predicate<String> isFirstCharUpper = str -> Character.isUpperCase(str.charAt(0));
            String[] inputWords = reader.readLine().split("[\\s.?!]+");

            inputWords = Arrays.stream(inputWords)
                    .filter(isFirstCharUpper)
                    .toArray(String[]::new);

            System.out.println(inputWords.length);
            Arrays.stream(inputWords)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
