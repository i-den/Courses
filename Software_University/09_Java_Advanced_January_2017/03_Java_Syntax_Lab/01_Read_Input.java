import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next();
        String secondWord = scanner.next();

        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        int thirdInt = scanner.nextInt();

        long intSum = firstInt + secondInt + thirdInt;

        String thirdWord = scanner.next();

        System.out.printf("%s %s %s %d", firstWord, secondWord, thirdWord, intSum);
    }
}