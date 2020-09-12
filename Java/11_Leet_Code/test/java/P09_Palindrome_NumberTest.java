import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P09_Palindrome_NumberTest {
    P09_Palindrome_Number solution;

    @BeforeEach
    void setUp() {
        solution = new P09_Palindrome_Number();
    }

    @Nested
    public class LeetCodeShownTest {
        @Test
        void test1() {
            int input = 121;
            assertTrue(solution.isPalindrome(input));
        }

        @Test
        void test2() {
            int input = -121;
            assertFalse(solution.isPalindrome(input));
        }

        @Test
        void test3() {
            int input = 10;
            assertFalse(solution.isPalindrome(input));
        }
    }
}