import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class VerybigSum {

    static long aVeryBigSum(long[] ar) {
        long totalSum = 0L;
        for (long num : ar) {
            totalSum += num;
        }
        return totalSum;
    }
}
