import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {

    private static final String PUSH_CMD = "1";
    private static final String POP_CMD = "2";
    private static final String PRINT_MAX_ELE_CMD = "3";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> inpNumsStack = new ArrayDeque<>();

        int cmdCnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cmdCnt; i++) {
            String[] currInput = scanner.nextLine().split("\\s+");
            switch (currInput[0]) {
                case PUSH_CMD:
                    inpNumsStack.addFirst(Integer.parseInt(currInput[1]));
                    break;
                case POP_CMD:
                    inpNumsStack.removeFirst();
                    break;
                case PRINT_MAX_ELE_CMD:
                default:
                    System.out.println(findMaxEleInStack(inpNumsStack));
                    break;
            }
        }
    }

    private static int findMaxEleInStack(ArrayDeque<Integer> numStack) {
        int maxEle = Integer.MIN_VALUE;
        for (Integer currNum : numStack) {
            if (currNum > maxEle) {
                maxEle = currNum;
            }
        }
        return maxEle;
    }
}