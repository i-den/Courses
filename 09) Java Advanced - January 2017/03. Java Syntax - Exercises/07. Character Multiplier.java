import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder firstStr = new StringBuilder(scanner.next());
        StringBuilder secStr = new StringBuilder(scanner.next());
        double sum = 0.0;

        while (true) {
            sum += firstStr.charAt(0) * secStr.charAt(0);

            firstStr.deleteCharAt(0);
            secStr.deleteCharAt(0);

            if (firstStr.length() == 0 || secStr.length() == 0) {
                break;
            }
        }

        if (firstStr.length() != 0 || secStr.length() != 0) {
            StringBuilder remStr = firstStr.length() != 0
                    ? firstStr
                    : secStr;

            for (char c : remStr.toString().toCharArray()) {
                sum += c;
            }
        }

        System.out.printf("%.0f", sum);
    }
}