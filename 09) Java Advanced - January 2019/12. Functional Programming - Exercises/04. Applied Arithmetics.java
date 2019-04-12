import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetic {

    private static final String STR_TO_ADD_ONE = "add";
    private static final String STR_TO_MULTIPLY_BY_TWO = "multiply";
    private static final String STR_TO_SUBTRACT_ONE = "subtract";
    private static final String STR_TO_PRINT = "print";
    private static final String STR_TO_END_INPUT = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        String inputCmd;
        while (!(inputCmd = scanner.nextLine()).equals(STR_TO_END_INPUT)) {
            switch (inputCmd) {
                case STR_TO_ADD_ONE:
                    inputNumbers = inputNumbers.stream().map(e -> e + 1).collect(Collectors.toList());
                    break;
                case STR_TO_MULTIPLY_BY_TWO:
                    inputNumbers = inputNumbers.stream().map(e -> e * 2).collect(Collectors.toList());
                    break;
                case STR_TO_SUBTRACT_ONE:
                    inputNumbers = inputNumbers.stream().map(e -> e - 1).collect(Collectors.toList());
                    break;
                case STR_TO_PRINT:
                default:
                    System.out.println(inputNumbers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
                    break;
            }
        }
    }
}
