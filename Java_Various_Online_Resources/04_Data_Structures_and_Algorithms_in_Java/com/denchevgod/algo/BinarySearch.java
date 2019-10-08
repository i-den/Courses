package com.denchevgod.algo;

import java.util.Arrays;

public class BinarySearch {


    private static int BinarySearch(int[] sortedArr, int key) {
        int low = 0;
        int high = sortedArr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int currVal = sortedArr[mid];

            if (currVal < key) {
                low = mid + 1;
            } else if (currVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int BinarySearchRec(int[] sortedArr, int key, int low, int high) {
        int mid = (low + high) / 2;
        int currVal = sortedArr[mid];

        if (currVal < key) {
            return BinarySearchRec(sortedArr, key, low + 1, high);
        } else if (currVal > key) {
            return BinarySearchRec(sortedArr, key, low, high - 1);
        } else if (currVal == key) {
            return currVal;
        }
        return -1;
    }
}
