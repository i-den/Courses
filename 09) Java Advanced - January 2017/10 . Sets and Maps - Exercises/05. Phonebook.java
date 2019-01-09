import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        while (true) {
            String[] currInput = scanner.nextLine()
                    .split("-");

            if (currInput[0].equals("search")) {
                break;
            }

            phonebook.put(currInput[0], currInput[1]);
        }

        while (true) {
            String currInput = scanner.nextLine();

            if (currInput.equals("stop")) {
                break;
            }

            if (phonebook.containsKey(currInput)) {
                System.out.println(currInput + " -> " + phonebook.get(currInput));
            } else {
                System.out.println("Contact " + currInput + " does not exist.");
            }
        }
    }
}