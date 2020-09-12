import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P27_Remove_ElementTest {
    P27_Remove_Element solution;

    @BeforeEach
    void setUp() {
        solution = new P27_Remove_Element();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            int[] arr = new int[]{3, 2, 2, 3};
            int val = 3;
            int expected = 2;
            int[] expectedArr = new int[]{2, 2};
            assertEquals(solution.removeElement(arr, val), expected);
            assertArrayEquals(Arrays.copyOf(arr, expected), expectedArr);
        }

        @Test
        void test2() {
            int[] arr = new int[]{0,1,2,2,3,0,4,2};
            int val = 2;
            int expected = 5;
            int[] expectedArr = new int[]{0, 1, 3, 0, 4};
            assertEquals(solution.removeElement(arr, val), expected);
            assertArrayEquals(Arrays.copyOf(arr, expected), expectedArr);
        }
    }
}