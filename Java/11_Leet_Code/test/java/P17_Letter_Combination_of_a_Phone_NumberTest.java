import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P17_Letter_Combination_of_a_Phone_NumberTest {
    P17_Letter_Combination_of_a_Phone_Number solution = new P17_Letter_Combination_of_a_Phone_Number();

    @BeforeEach
    void setUp() {
        solution = new P17_Letter_Combination_of_a_Phone_Number();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            String input = "23";
            List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
            assertEquals(solution.letterCombinations(input), expected);
        }
    }
}