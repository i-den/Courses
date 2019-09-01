import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tarNum = scanner.nextInt();

        int finalNum = tarNum > 20
                ? 20
                : tarNum;

        for (int i = 1; i <= finalNum; i++) {
            for (int j = 1; j <= finalNum; j++) {
                if (i + j == tarNum) {
                    System.out.printf("%d + %d = %d%n", i, j, tarNum);
                }
            }
        }

        if (tarNum < 20) {
            for (int i = tarNum + 1; i <= 20; i++) {
                for (int j = 1; j <= i; j++) {
                    if (i - j == tarNum) {
                        System.out.printf("%d - %d = %d%n", i, j, tarNum);
                    }
                }
            }
        }
    }
}