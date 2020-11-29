public class P08_String_to_Integer {

    public int myAtoi(String str) {
        char[] digits = str.toCharArray();
        int multiplier = 1;

        int i = 0;
        int num = 0;
        while(i < digits.length - 1 && digits[i] == ' ') {
            i++;
        }
        if(digits[i] == '-' || digits[i] == '+') {
            if (digits[i] == '-') multiplier = -1;
            i++;
        }

        while(i < digits.length) {
            if(!Character.isDigit(digits[i])) {
                return num * multiplier;
            }
            int digitToAdd = Character.getNumericValue(digits[i]);

            if (multiplier > 0) {
                if (num > 214748364 || (num == 214748364 && digitToAdd > 7)) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if(num > 214748364 || (num == 214748364 && digitToAdd > 8)) {
                    return Integer.MIN_VALUE;
                }
            }

            num = (num * 10) + digitToAdd;
            i++;
        }

        return num * multiplier;
    }
}
