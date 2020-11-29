public class P75_Sort_Colors {
    public void sortColors(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int pivotIdx = left;

        while(left < right) {
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        arr[pivotIdx] = arr[right];
        arr[right] = pivot;

        return right;
    }
}
