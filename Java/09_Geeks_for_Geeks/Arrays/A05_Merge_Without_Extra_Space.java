package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A05_Merge_Without_Extra_Space {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            input.readLine();
            int[] arr1 = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] arr2 = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            merge(arr1, arr2);
        }
    }

    public static void merge(int[] leftArr, int[] rightArr) {
        int leftPtr = leftArr.length - 1;
        int rightPtr = 0;

        while (leftPtr >= 0 && rightPtr < rightArr.length) {
            int leftEle = leftArr[leftPtr];
            int rightEle = rightArr[rightPtr];
            if (leftEle > rightEle) {
                leftArr[leftPtr] = rightEle;
                rightArr[rightPtr] = leftEle;
            } else {
                break;
            }
            leftPtr--;
            rightPtr++;
        }

        Arrays.sort(leftArr);
        Arrays.sort(rightArr);
        printMergedArrays(leftArr, rightArr);
    }

    private static void printMergedArrays(int[] leftArr, int[] rightArr) {
        StringBuilder mergedArraysElements = new StringBuilder(leftArr.length + rightArr.length);
        for (int i : leftArr) {
            mergedArraysElements.append(i);
            mergedArraysElements.append(" ");

        }
        for (int i : rightArr) {
            mergedArraysElements.append(i);
            mergedArraysElements.append(" ");
        }
        System.out.println(mergedArraysElements.toString().trim());
    }
}
