import java.util.ArrayDeque;

public class Jar<T> {

    private ArrayDeque<T> deque;

    public Jar() {
        deque = new ArrayDeque<>();
    }

    public void add (T element) {
        deque.addFirst(element);
    }

    public T remove() {
        return deque.removeFirst();
    }
}
