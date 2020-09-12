import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P04_Median_of_Two_Sorted_ArraysTest {
    P04_Median_of_Two_Sorted_Arrays solution;

    @BeforeEach
    void setUp() {
        solution = new P04_Median_of_Two_Sorted_Arrays();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            int[] arr1 = new int[]{1, 3};
            int[] arr2 = new int[]{2};
            double expected = 2D;
            assertEquals(solution.findMedianSortedArrays(arr1, arr2), expected);
        }

        @Test
        void test2() {
            int[] arr1 = new int[]{1, 2};
            int[] arr2 = new int[]{3, 4};
            double expected = 2.5D;
            assertEquals(solution.findMedianSortedArrays(arr1, arr2), expected);
        }

        @Test
        void test3() {
            int[] arr1 = new int[]{0, 0};
            int[] arr2 = new int[]{0, 0};
            double expected = 0D;
            assertEquals(solution.findMedianSortedArrays(arr1, arr2), expected);
        }

        @Test
        void test4() {
            int[] arr1 = new int[]{};
            int[] arr2 = new int[]{1};
            double expected = 1D;
            assertEquals(solution.findMedianSortedArrays(arr1, arr2), expected);
        }

        @Test
        void test5() {
            int[] arr1 = new int[]{2};
            int[] arr2 = new int[]{};
            double expected = 2D;
            assertEquals(solution.findMedianSortedArrays(arr1, arr2), expected);
        }
    }
}