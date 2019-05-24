import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputNums = Arrays.stream(scanner.nextLine().split("[,\\s]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = inputNums.stream().mapToInt(Integer::valueOf).sum();

        System.out.printf("Count = %d%nSum = %d", inputNums.size(), sum);
    }
}