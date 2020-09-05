package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S11_ATOI {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(Integer.parseInt(input.readLine()));
        } catch (Exception e) {
            System.out.println(-1);
        }
    }
}
