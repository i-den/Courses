import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForNames {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer reqNameLen = Integer.parseInt(reader.readLine());
            Predicate<String> checkNameLen = str -> str.length() <= reqNameLen;
            Consumer<String> printName = System.out::println;

            Arrays.stream(reader.readLine().split("\\s+"))
                    .filter(checkNameLen)
                    .forEach(printName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}