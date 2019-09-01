import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        while (true) {
            String currName = scanner.nextLine();

            if (currName.equals("stop")) {
                break;
            }

            String currEmailAcc = scanner.nextLine();

                if (currEmailAcc.matches(".*(us|com|uk)$")) {
                continue;
            }

            emails.put(currName, currEmailAcc);
        }

        for (String currEmailHolder : emails.keySet()) {
            System.out.println(currEmailHolder + " -> " + emails.get(currEmailHolder));
        }
    }
}