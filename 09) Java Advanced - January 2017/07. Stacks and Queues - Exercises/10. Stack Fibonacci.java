import java.util.ArrayDeque;
import java.util.Scanner;

public class StackFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> fibStack = new ArrayDeque<>();

        int fibNum = scanner.nextInt();

        fibStack.push(1);
        fibStack.push(1);
        int currInd = 1;

        while (currInd != fibNum) {
            int firstPoppedNum = fibStack.pop();
            int secPoppedNum = fibStack.pop();

            fibStack.push(secPoppedNum);
            fibStack.push(firstPoppedNum);
            fibStack.push(firstPoppedNum + secPoppedNum);

            currInd++;
        }

        System.out.println(fibStack.pop());
    }
}