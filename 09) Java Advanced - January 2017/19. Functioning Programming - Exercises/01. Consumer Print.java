import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> printStr = System.out::println;

        try { // -.-
            Arrays.stream(reader.readLine().split("\\s+")).forEach(printStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}