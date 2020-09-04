package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class A14_Kth_Smallest_Element {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            int arrLen = Integer.parseInt(input.readLine());
            int[] arr = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int kthSmallestNum = Integer.parseInt(input.readLine());
            System.out.println(findKthSmallestInArrHeap(arr, kthSmallestNum));
        }
    }

    private static int findKthSmallestInArrSort(int[] arr, int kthSmallestNum) {
        Arrays.sort(arr);
        return arr[kthSmallestNum - 1];
    }

    private static int findKthSmallestInArrHeap(int[] arr, int kthSmallestNum) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(arr.length, Collections.reverseOrder());
        for (int i : arr) {
            minHeap.add(i);
            if (minHeap.size() > kthSmallestNum) {
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }
}
