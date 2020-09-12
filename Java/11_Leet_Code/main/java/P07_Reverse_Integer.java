public class P07_Reverse_Integer {

    public  int reverse(int x) {
        int rev = 0;

        int maxNonOvflVal = Integer.MAX_VALUE / 10;
        int minNonOvflVal = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (rev > maxNonOvflVal || rev == maxNonOvflVal && pop > 7)
                return 0;
            if (rev < minNonOvflVal || rev == minNonOvflVal && pop < -8)
                return 0;

            rev = rev * 10 + pop;
        }
        return rev;
    }
}
