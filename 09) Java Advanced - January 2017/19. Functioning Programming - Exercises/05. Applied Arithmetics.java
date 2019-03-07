import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class FindEvensOrOdds {

    private static final String strToEndInput = "end";
    private static final String strToIncrement = "add";
    private static final String strToMultipleBy2 = "multiply";
    private static final String strToDecrement = "subtract";
    private static final String strToPrint = "print";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int[] numArr = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            UnaryOperator<Integer> incrementFn = currNum -> currNum + 1;
            UnaryOperator<Integer> decrementFn = currNum -> currNum - 1;
            UnaryOperator<Integer> multiplyFn = currNum -> currNum * 2;
            Consumer<int[]> printFn = intArr -> Arrays.stream(intArr).forEach(e -> System.out.print(e + " "));

            String currCommand;
            while (!strToEndInput.equals((currCommand = reader.readLine()))) {
                switch (currCommand) {
                    case strToIncrement:
                        numArr = Arrays.stream(numArr).map(incrementFn::apply).toArray();
                        break;
                    case strToDecrement:
                        numArr = Arrays.stream(numArr).map(decrementFn::apply).toArray();
                        break;
                    case strToMultipleBy2:
                        numArr = Arrays.stream(numArr).map(multiplyFn::apply).toArray();
                        break;
                    default:
                        printFn.accept(numArr);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}