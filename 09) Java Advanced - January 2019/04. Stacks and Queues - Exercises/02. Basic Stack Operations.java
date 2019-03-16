import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        inputManager.getInitialInput();
        inputManager.pushNumsOntoStack();
        inputManager.popNumsFromStack();

        if (inputManager.numIsFoundInStack()) {
            System.out.println(true);
        } else {
            System.out.println(inputManager.smallestNumInQueue());
        }
    }
}

class InputManager {

    private Scanner scanner;
    private ArrayDeque<Integer> numStack;

    private int elementsToPushCnt;
    private int elementsToPopCnt;
    private int numToSearchFor;

    InputManager() {
        this.scanner = new Scanner(System.in);
        this.numStack = new ArrayDeque<>();
    }

    void getInitialInput() {
        String[] initialInput = this.scanner.nextLine().split("\\s+");
        this.elementsToPushCnt = Integer.parseInt(initialInput[0]);
        this.elementsToPopCnt = Integer.parseInt(initialInput[1]);
        this.numToSearchFor = Integer.parseInt(initialInput[2]);
    }

    void pushNumsOntoStack() {
        for (int i = 0; i < elementsToPushCnt; i++) {
            this.numStack.addFirst(this.scanner.nextInt());
        }
    }

    void popNumsFromStack() {
        for (int i = 0; i < elementsToPopCnt; i++) {
            this.numStack.removeFirst();
        }
    }

    boolean numIsFoundInStack() {
        return this.numStack.contains(this.numToSearchFor);
    }

    int smallestNumInQueue() {
        if (this.numStack.isEmpty()) {
            return 0;
        }
        int smallestNum = Integer.MAX_VALUE;
        for (Integer currNum : this.numStack) {
            if (currNum < smallestNum) {
                smallestNum = currNum;
            }
        }
        return smallestNum;
    }
}