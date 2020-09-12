import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P06_ZigZag_ConversionTest {
    P06_ZigZag_Conversion solution;

    @BeforeEach
    void setUp() {
        solution = new P06_ZigZag_Conversion();
    }

    @Nested
    public class LeetCodeShownTests {
        @Test
        void test1() {
            String input = "PAYPALISHIRING";
            int numRows = 3;
            String expected = "PAHNAPLSIIGYIR";
            assertEquals(solution.convert(input, numRows), expected);
        }

        @Test
        void test2() {
            String input = "PAYPALISHIRING";
            int numRows = 4;
            String expected = "PINALSIGYAHRPI";
            assertEquals(solution.convert(input, numRows), expected);
        }
    }
}