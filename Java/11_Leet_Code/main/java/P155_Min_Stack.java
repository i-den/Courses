import java.util.ArrayDeque;

public class P155_Min_Stack {
    ArrayDeque<Integer> minStack = new ArrayDeque<>();
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    public P155_Min_Stack() {

    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peekFirst()) {
            minStack.addFirst(x);
        }
        stack.addFirst(x);
    }

    public void pop() {
        int n = stack.removeFirst();
        if (n == minStack.peekFirst()) {
            minStack.removeFirst();
        }
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }
}
