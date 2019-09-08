import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    private static String strToKeepEvenNums = "even";
    private static String strToKeepOddNums = "odd";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Consumer<Integer> printNum = System.out::println;
        Predicate<Integer> evenOrOddFn;

        try {
            int[] inputNums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            String inpStrToKeepEvenOrOddNums = reader.readLine();

            if (strToKeepEvenNums.equals(inpStrToKeepEvenOrOddNums)) {
                evenOrOddFn = inpNum -> inpNum % 2 == 0;
            } else {
                evenOrOddFn = inpNum -> inpNum % 2 != 0;
            }

            for (int i = inputNums[0]; i <= inputNums[1]; i++) {
                if (evenOrOddFn.test(i)) {
                    System.out.print(i + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}