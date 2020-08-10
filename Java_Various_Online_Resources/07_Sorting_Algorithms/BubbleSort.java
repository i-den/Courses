import java.util.List;

public class BubbleSort {

    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        int n = list.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                T first = list.get(i - 1);
                T second = list.get(i);

                if (first.compareTo(second) > 0) { // first is smaller
                    list.set(i - 1, second);
                    list.set(i, first);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static <T extends Comparable<T>> void bubbleSort2(List<T> list) {
        int n = list.size();
        boolean swapped;
        do {
            swapped = false;
            int anchor = 0; // if there are no swaps after the anchor it should not be iterated
            for (int i = 1; i < n; i++) {
                T first = list.get(i - 1);
                T second = list.get(i);

                if (first.compareTo(second) > 0) {
                    list.set(i - 1, second);
                    list.set(i, first);
                    swapped = true;
                    anchor = i;
                }
            }
            n = anchor;
        } while (swapped);
    }
}
