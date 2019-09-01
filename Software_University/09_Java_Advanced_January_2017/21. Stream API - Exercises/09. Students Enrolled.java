import java.util.Scanner;

public class StudentsEnrolled {

    public static String strToEndInput = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String currInput;
        while (!strToEndInput.equals((currInput = scanner.nextLine()))) {
            if (currInput.matches("\\d{4}1[45].*")) {
                System.out.println(currInput.substring(currInput.indexOf(" ")));
            }
        }
    }
}
