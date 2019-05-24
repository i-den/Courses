import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonor {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> printStr = strToPrint -> System.out.printf(
                "%1$s %2$s%3$s",
                "Sir",
                strToPrint,
                System.lineSeparator()
        );

        try {
            Arrays.stream(reader.readLine().split("\\s+")).forEach(printStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}