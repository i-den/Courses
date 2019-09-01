import java.util.HashMap;
import java.util.Scanner;

public class RecursiveFibonacci {

    private static HashMap<Integer, Integer> fibMemo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fibNum = scanner.nextInt();
        fibMemo = new HashMap<>();

        System.out.println(getFib(fibNum));
    }

    private static int getFib(int fibNum) {
        if (fibNum <= 1) {
            return 1;
        }

        if (fibMemo.containsKey(fibNum)) {
            return fibMemo.get(fibNum);
        }

        fibMemo.put(fibNum, getFib(fibNum -1) + getFib(fibNum - 2));

        return fibMemo.get(fibNum);
    }
}