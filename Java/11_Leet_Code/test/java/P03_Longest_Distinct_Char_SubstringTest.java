import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P03_Longest_Distinct_Char_SubstringTest {
    private P03_Longest_Distinct_Char_Substring solution;

    @BeforeEach
    void setUp() {
        solution = new P03_Longest_Distinct_Char_Substring();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            String input = "abcabcbb";
            int expected = 3;
            assertCorrectOutput(input, expected);
        }

        @Test
        void test2() {
            String input = "bbbbb";
            int expected = 1;
            assertCorrectOutput(input, expected);
        }

        @Test
        void test3() {
            String input = "pwwkew";
            int expected = 3;
            assertCorrectOutput(input, expected);
        }

        @Test
        void test4() {
            String input = "";
            int expected = 0;
            assertCorrectOutput(input, expected);
        }

        private void assertCorrectOutput(String input, int expected) {
            assertEquals(solution.lengthOfLongestSubstring(input), expected);
            assertEquals(solution.lengthOfLongestSubstring2(input), expected);
            assertEquals(solution.gfgSolution(input), expected);
        }
    }
}