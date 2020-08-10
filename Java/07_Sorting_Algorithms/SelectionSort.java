import java.util.List;

public class SelectionSort {

    public static <T extends Comparable<T>> void selectionSort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T min = list.get(i);
            int minIdx = i;
            for (int j = i + 1; j < list.size(); j++) {
                T curr = list.get(j);
                if (curr.compareTo(min) < 0) {
                    min = curr;
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                list.set(minIdx, list.get(i));
                list.set(i, min);
            }
        }
    }
}
