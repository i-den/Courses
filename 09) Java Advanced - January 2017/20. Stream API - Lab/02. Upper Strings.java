import java.util.Arrays;
import java.util.Scanner;

public class UpperStrings {

    public static void main(String[] args) {
        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(String::toUpperCase)
                .forEach(e -> System.out.print(e + " "));
    }
}