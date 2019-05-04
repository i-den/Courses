import java.util.List;

public class ListUtils<T extends Comparable> {

    public static <T extends Comparable>T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return list.stream()
                .sorted()
                .findFirst()
                .get();
    }

    public static <T extends Comparable>T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return list.stream().min((o1, o2) -> o2.compareTo(o1))
                .get();
    }
}
