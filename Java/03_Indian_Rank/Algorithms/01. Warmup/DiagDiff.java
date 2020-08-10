import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DiagDiff {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int firstInd = 0;
        int lastInd = arr.size() - 1;
        int firstSum = 0;
        int secSum = 0;
        for (List<Integer> integers : arr) {
            firstSum += integers.get(firstInd);
            secSum += integers.get(lastInd);
            firstInd++;
            lastInd--;
        }

        return Math.abs(firstSum - secSum);
    }
}
