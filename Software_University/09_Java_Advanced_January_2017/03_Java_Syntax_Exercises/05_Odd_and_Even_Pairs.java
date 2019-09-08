import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream((scanner.nextLine().split("\\s+")))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (inputArr.length % 2 == 0) {
            for (int i = 0; i < inputArr.length; i += 2) {
                int firstNum = inputArr[i];
                int secNum = inputArr[i + 1];

                System.out.println(checkNumbers(firstNum, secNum));
            }
        } else {
            System.out.println("invalid length");
        }
    }

    private static String checkNumbers(int firstNum, int secNum) {
        if (firstNum % 2 == 0 && secNum % 2 == 0) {
            return String.format("%d, %d -> both are even", firstNum, secNum);
        }

        if (firstNum % 2 != 0 && secNum % 2 != 0) {
            return String.format("%d, %d -> both are odd", firstNum, secNum);
        }

        return String.format("%d, %d -> different", firstNum, secNum);
    }
}