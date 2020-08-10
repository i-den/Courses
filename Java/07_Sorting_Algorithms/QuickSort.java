public class QuickSort {

    public static void quickSortArr(int[] arr) {
        quickSortArr(arr, 0, arr.length - 1);
    }

    private static void quickSortArr(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIdx = partition(arr, start, end);
            quickSortArr(arr, start, partitionIdx - 1);
            quickSortArr(arr, partitionIdx + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = (start - 1);

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
