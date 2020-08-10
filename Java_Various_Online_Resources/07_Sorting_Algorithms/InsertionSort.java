import java.util.List;

public class InsertionSort {

    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            int j = i - 1;
            T curr = list.get(i);
            T left;

            while (j >= 0 && curr.compareTo(left = list.get(j)) < 0) {
                list.set(j + 1, left);
                j--;
            }
            list.set(j + 1, curr);
        }
    }
}
