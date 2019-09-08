import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int divisibleNum = scanner.nextInt();

        Collections.reverse(inputNumbers);

        System.out.println(inputNumbers.stream().filter(n -> n % divisibleNum != 0)
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}
