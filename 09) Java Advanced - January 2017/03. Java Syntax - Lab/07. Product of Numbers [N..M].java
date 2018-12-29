import java.math.BigInteger;
import java.util.Scanner;

public class Problem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();

        BigInteger fact = findFactorialInRange(new BigInteger("1"), startNum, endNum);
        System.out.printf("product[%d..%d] = %d", startNum, endNum, fact);
    }

    private static BigInteger findFactorialInRange(BigInteger accumulator, int currNum, int finalNum) {

        if (currNum > finalNum) {
            return accumulator;
        }

        accumulator = accumulator.multiply(BigInteger.valueOf(currNum));

        return findFactorialInRange(accumulator, currNum + 1, finalNum);
    }
}