import java.util.ArrayDeque;
import java.util.Scanner;

public class DecToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decNum = scanner.nextInt();

        System.out.println(getBinaryResult(decNum));
    }

    private static String getBinaryResult(int decNum) {
        if (decNum == 0) {
            return "0";
        }

        ArrayDeque<Integer> binNum = new ArrayDeque<>();
        StringBuilder binNumStr = new StringBuilder();

        while (decNum != 0) {
            binNum.push(decNum % 2);
            decNum /= 2;
        }

        while (!binNum.isEmpty()) {
            binNumStr.append(binNum.pop());
        }

        return binNumStr.toString();
    }
}