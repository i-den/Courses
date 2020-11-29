import java.util.Arrays;

public class P66_Plus_One {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        int[] result = new int[digits.length];

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit + carry == 10) {
                result[i] = 0;
            } else {
                result[i] = digits[i] + carry;
                carry = 0;
            }
        }
        if (carry == 1) {
            int[] ret = Arrays.copyOf(result, result.length + 1);
            ret[0] = carry;
            return ret;
        }
        return result;
    }
}
