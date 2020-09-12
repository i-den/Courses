import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P15_3SumTest {
    P15_3Sum solution;

    @BeforeEach
    void setUp() {
        solution = new P15_3Sum();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            int[] input = new int[]{-1,0,1,2,-1,-4};
            List<List<Integer>> expected = new ArrayList<>();
            expected.add(Arrays.asList(-1, -1, 2));
            expected.add(Arrays.asList(-1, 0, 1));
            assertEquals(solution.threeSums(input), expected);
        }

        @Test
        void test2() {
            int[] input = new int[]{};
            List<List<Integer>> expected = new ArrayList<>();
            assertEquals(solution.threeSums(input), expected);
        }

        @Test
        void test3() {
            int[] input = new int[]{0};
            List<List<Integer>> expected = new ArrayList<>();
            assertEquals(solution.threeSums(input), expected);
        }
    }
}