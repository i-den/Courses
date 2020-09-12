import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P16_3Sum_ClosestTest {
    P16_3Sum_Closest solution;

    @BeforeEach
    void setUp() {
        solution = new P16_3Sum_Closest();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            int[] nums = new int[]{-1,2,1,-4};
            int target = 1;
            int expected = 2;
            assertEquals(solution.threeSumClosest(nums, target), expected);
        }

        @Test
        void test2() {
            int[] nums = new int[]{1, 1, -1, -1, 3};
            int target = -1;
            int expected = -1;
            assertEquals(solution.threeSumClosest(nums, target), expected);
        }

        @Test
        void test3() {
            int[] nums = new int[]{1,2,4,8,16,32,64,128};
            int target = 82;
            int expected = 82;
            assertEquals(solution.threeSumClosest(nums, target), expected);
        }
    }
}