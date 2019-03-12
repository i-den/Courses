import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class AverageOfDoubles {

    public static void main(String[] args) {
        OptionalDouble numExists = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .filter(str -> !str.isEmpty())
                .mapToDouble(Double::parseDouble)
                .filter(num -> num % 2 == 0)
                .min();

        System.out.println(
                numExists.isPresent()
                        ? String.format("%1$.2f", numExists.getAsDouble())
                        : "No match"
        );
    }
}