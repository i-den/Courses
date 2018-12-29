import java.util.Scanner;

public class A_Read_Input {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();

        firstName = checkName(firstName);
        lastName = checkName(lastName);

        System.out.printf("Hello, %s %s!", firstName, lastName);
    }

    private static String checkName(String nameToCheck) {
        return nameToCheck.isEmpty()
                ? "*****"
                : nameToCheck;
    }
}