import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUppercaseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split("[\\s.]+"))
                .filter(w -> Character.isUpperCase(w.charAt(0)))
                .collect(Collectors.toList());

        System.out.printf("%d%n%s", words.size(), String.join(System.lineSeparator(), words));
    }
}