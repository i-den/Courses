import java.util.ArrayDeque;

public class Jar<T> {

    private ArrayDeque<T> arrayDeque;

    public Jar() {
        arrayDeque = new ArrayDeque<>();
    }

    public void add(T element) {
        arrayDeque.addFirst(element);
    }

    public T remove() {
        return arrayDeque.removeFirst();
    }
}