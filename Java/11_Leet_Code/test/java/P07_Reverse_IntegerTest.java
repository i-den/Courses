import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P07_Reverse_IntegerTest {
    P07_Reverse_Integer solution;

    @BeforeEach
    void setUp() {
        solution = new P07_Reverse_Integer();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            int input = 123;
            int expected = 321;
            assertEquals(solution.reverse(input), expected);
        }

        @Test
        void test2() {
            int input = -123;
            int expected = -321;
            assertEquals(solution.reverse(input), expected);
        }

        @Test
        void test3() {
            int input = 120;
            int expected = 21;
            assertEquals(solution.reverse(input), expected);
        }
    }
}