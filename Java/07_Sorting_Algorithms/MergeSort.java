import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
        if (list.size() <= 1) {
            return list;
        }

        int midPoint = list.size() / 2;
        List<T> left = new ArrayList<>(list.subList(0, midPoint));
        List<T> right = new ArrayList<>(list.subList(midPoint, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);
        return mergeList(left, right, list);
    }

    private static <T extends Comparable<T>> List<T> mergeList(List<T> left, List<T> right, List<T> list) {
        int leftPtr = 0, rightPtr = 0, listPtr = 0;

        while (leftPtr < left.size() && rightPtr < right.size()) {
            T leftEle = left.get(leftPtr);
            T rightEle = right.get(rightPtr);
            if (leftEle.compareTo(rightEle) <= 0) {
                list.set(listPtr++, leftEle);
                leftPtr++;
            } else {
                list.set(listPtr++, rightEle);
                rightPtr++;
            }
        }

        if (leftPtr >= left.size()) {
            for (; rightPtr < right.size(); rightPtr++) {
                list.set(listPtr++, right.get(rightPtr));
            }
        } else {
            for (; leftPtr < left.size(); leftPtr++) {
                list.set(listPtr++, left.get(leftPtr));
            }
        }
        return list;
    }

    public static int[] mergeSortArr(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int midPoint = arr.length / 2;
        int rightSize = arr.length % 2 == 0 ? midPoint : midPoint + 1;

        int[] left = new int[midPoint];
        int[] right = new int[rightSize];

        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, midPoint, right, 0, right.length);

        left = mergeSortArr(left);
        right = mergeSortArr(right);

        return mergeArr(left, right);
    }

    private static int[] mergeArr(int[] left, int[] right) {

        int[] res = new int[left.length + right.length];
        int leftPtr = 0, rightPtr = 0, resPtr = 0;

        while (leftPtr < left.length || rightPtr < right.length) { // while any of the arrays have elements in them
            if (leftPtr < left.length && rightPtr < right.length) { // if both arrays have elements in them
                if (left[leftPtr] <= right[rightPtr]) { // right arr's ele is bigger
                    res[resPtr++] = left[leftPtr++];
                } else {                                // left arr's ele is bigger
                    res[resPtr++] = right[rightPtr++];
                }
            } else if (leftPtr < left.length) {                      // if left array have elements
                res[resPtr++] = left[leftPtr++];
            } else if (rightPtr < right.length) {                     // if right array have elements
                res[resPtr++] = right[rightPtr++];
            }
        }

        return res;
    }
}
