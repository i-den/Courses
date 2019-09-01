import java.util.HashMap;
import java.util.Scanner;

public class RecursiveFibonacci {

    private static final HashMap<Long, Long> fibonacciResults = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getFibonacci(Long.parseLong((new Scanner(System.in)).nextLine())));
    }

    private static Long getFibonacci(Long currNum) {
        if (currNum <= 1) {
            return 1L;
        }

        if (!fibonacciResults.containsKey(currNum)) {
            fibonacciResults.put(
                    currNum,
                    getFibonacci(currNum -1) + getFibonacci(currNum -2)
            );
        }

        return  fibonacciResults.get(currNum);
    }
}