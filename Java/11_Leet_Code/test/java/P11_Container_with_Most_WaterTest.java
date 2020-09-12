import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P11_Container_with_Most_WaterTest {
    P11_Container_with_Most_Water solution;

    @BeforeEach
    void setUp() {
        solution = new P11_Container_with_Most_Water();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            int[] input = new int[]{1,8,6,2,5,4,8,3,7};
            int expected = 49;
            assertEquals(solution.maxArea(input), expected);
        }
    }
}