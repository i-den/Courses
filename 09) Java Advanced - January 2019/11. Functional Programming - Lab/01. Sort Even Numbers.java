import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputEvenNums = Arrays.stream(scanner.nextLine().split("[,\\s]+"))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(
                inputEvenNums.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))
        );

        System.out.println(
                inputEvenNums.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
        );
    }
}