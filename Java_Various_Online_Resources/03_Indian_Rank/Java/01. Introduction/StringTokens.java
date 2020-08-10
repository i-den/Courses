package com.denchevgod;

import java.util.Scanner;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();

        if (s.equals(" ") || s.length() == 0) {
            System.out.println("0");
        } else if (s.length() <= 400000) {
            String[] a = s.split("[ !,?.\\_'@]+");
            System.out.println(a.length);
            for (String s1 : a) {
                System.out.println(s1);
            }
        }

        scan.close();
    }
}
