import java.util.Arrays;
import java.util.Scanner;

public class TakeTwo {

    public static void main(String[] args) {
        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .distinct()
                .filter(x -> x >= 10 && x <= 20)
                .limit(2)
                .forEach(x -> System.out.print(x + " "));
    }
}