import java.util.ArrayDeque;
import java.util.Scanner;

public class DecToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer inpDecNum = scanner.nextInt();
        System.out.println(getBinaryRepresentation(inpDecNum));
    }

    private static String getBinaryRepresentation(Integer decimalNum) {
        if (decimalNum == 0) {
            return "0";
        }

        ArrayDeque<Integer> decimalRemainder = new ArrayDeque<>();
        StringBuilder binaryRepresentation = new StringBuilder();

        while (decimalNum != 0) {
            decimalRemainder.addFirst(decimalNum % 2);
            decimalNum /= 2;
        }

        while (!decimalRemainder.isEmpty()) {
           binaryRepresentation.append(decimalRemainder.removeFirst());
        }

        return binaryRepresentation.toString();
    }
}