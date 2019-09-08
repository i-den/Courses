import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = scanner.nextDouble();
        double secNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();

        double firstRes = firstForm(firstNum, secNum, thirdNum);
        double secRes = secForm(firstNum, secNum, thirdNum);
        double thirdRes = thirdForm(firstNum, secNum, thirdNum, firstRes, secRes);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", firstRes, secRes, thirdRes);
    }


    private static double firstForm(double a, double b, double c) {
        return Math.pow(((Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2))), (a + b + c) / Math.sqrt(c));
    }

    private static double secForm(double a, double b, double c) {
        return (Math.pow( (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3)), (a - b)));
    }

    private static double thirdForm(double a, double b, double c, double f1, double f2) {
        return Math.abs(((a + b + c) / 3) - ((f1 + f2) / 2));
    }
}