import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlusMinus {

    static void plusMinus(int[] arr) {
        float positives = 0;
        float negatives = 0;
        float zeros = 0;

        for (int i : arr) {
            if (i > 0) {
                positives++;
            } else if (i < 0) {
                negatives++;
            } else {
                zeros++;
            }
        }

        System.out.printf("%.6f%n", positives / arr.length);
        System.out.printf("%.6f%n", negatives / arr.length);
        System.out.printf("%.6f%n", zeros / arr.length);
    }
}
