import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Staircase {

    static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            int spaceCnt = n - i;
            System.out.println(repeat(" ", spaceCnt) + repeat("#", i));
        }
    }

    static String repeat(String s, int cnt) {
        return new String(new char[cnt]).replace("\0", s);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
