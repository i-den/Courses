import java.util.Arrays;
import java.util.Scanner;

public class PredicateForNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNameLen = Integer.parseInt(scanner.nextLine());

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(e -> e.length() <= maxNameLen)
                .forEach(System.out::println);
    }
}
