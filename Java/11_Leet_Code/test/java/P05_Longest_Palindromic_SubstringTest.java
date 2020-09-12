import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P05_Longest_Palindromic_SubstringTest {
    P05_Longest_Palindromic_Substring solution;

    @BeforeEach
    void setUp() {
        solution = new P05_Longest_Palindromic_Substring();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            String input = "babad";
            String expected = "aba";
            System.out.println(solution.longestPalindromeExpandCenter(input));
        }

        @Test
        void test2() {
            String input = "cbbd";
            String expected = "bb";
            System.out.println(solution.longestPalindromeExpandCenter(input));
        }
    }
}