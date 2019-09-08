import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstX = scanner.nextInt();
        int firstY = scanner.nextInt();

        int secX = scanner.nextInt();
        int secY = scanner.nextInt();

        int thirdX = scanner.nextInt();
        int thirdY = scanner.nextInt();

        System.out.println(getTriangleArea(firstX, firstY, secX, secY, thirdX, thirdY));
    }

    private static int getTriangleArea(int firstX, int firstY, int secX, int secY, int thirdX, int thirdY) {
        return Math.abs((firstX * (secY - thirdY) + secX * (thirdY - firstY) + thirdX * (firstY - secY)) / 2);
    }
}