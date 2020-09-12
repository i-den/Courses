import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P01_Two_SumTest {
    P01_Two_Sum solution;

    @BeforeEach
    public void setUp() {
        solution = new P01_Two_Sum();
    }

    @Test
    void givenArrayFilledWith1s_whenTargetIs2_shouldReturnFirstTwoIndexes() {
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int target = 2;
        int[] expected = new int[]{0, 1};
        int[] result = solution.twoSum(arr, target);
        assertArrayEquals(result, expected);
    }

    @Test
    void givenArrayFilledWithNumbers_whenCorrectIndexesAre0AndLast_shouldReturnThoseIndexes() {
        int[] arr = new int[]{10, 1, 1, 1, 1, 1, 1, 1, 10};
        int target = 20;
        int[] expected = new int[]{0, arr.length - 1};
        int[] result = solution.twoSum(arr, target);
        assertArrayEquals(result, expected);
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            int[] arr = new int[]{2, 7, 11, 15};
            int target = 9;
            int[] expected = new int[]{0, 1};
            int[] result = solution.twoSum(arr, target);
            assertArrayEquals(result, expected);
        }

        @Test
        void test2() {
            int[] arr = new int[]{3, 2, 4};
            int target = 6;
            int[] expected = new int[]{1, 2};
            int[] result = solution.twoSum(arr, target);
            assertArrayEquals(result, expected);
        }

        @Test
        void test3() {
            int[] arr = new int[]{3, 3};
            int target = 6;
            int[] expected = new int[]{0, 1};
            int[] result = solution.twoSum(arr, target);
            assertArrayEquals(result, expected);
        }
    }
}