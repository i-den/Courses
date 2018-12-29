import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rectFirstSide = scanner.nextDouble();
        double rectSecSide = scanner.nextDouble();

        System.out.printf("%.2f", rectFirstSide * rectSecSide);
    }
}