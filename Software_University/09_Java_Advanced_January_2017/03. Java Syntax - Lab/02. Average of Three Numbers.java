import java.util.Arrays;
import java.util.Scanner;

public class A_Read_Input {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] intArr = {scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()};
        double sum = Arrays.stream(intArr).reduce(0.0, (a, e) -> (a + e)) / intArr.length;

        System.out.printf("%.2f", sum);
    }
}