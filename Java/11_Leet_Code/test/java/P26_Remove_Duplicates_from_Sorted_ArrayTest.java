import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P26_Remove_Duplicates_from_Sorted_ArrayTest {
    P26_Remove_Duplicates_from_Sorted_Array solution;

    @BeforeEach
    void setUp() {
        solution = new P26_Remove_Duplicates_from_Sorted_Array();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            int[] arr = new int[]{1,1,2};
            int expected = 2;
            int[] expectedArr = new int[]{1, 2};
            assertEquals(solution.removeDuplicates(arr), expected);
            assertArrayEquals(Arrays.copyOf(arr, expected), expectedArr);
        }

        @Test
        void test2() {
            int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
            int expected = 5;
            int[] expectedArr = new int[]{0, 1, 2, 3, 4};
            assertEquals(solution.removeDuplicates(arr), expected);
            assertArrayEquals(Arrays.copyOf(arr, expected), expectedArr);
        }
    }
}