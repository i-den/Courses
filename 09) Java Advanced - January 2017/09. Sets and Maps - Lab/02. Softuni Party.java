import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftuniParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> VIP = new TreeSet<>();
        HashSet<String> regulars = new HashSet<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("PARTY")) {
                break;
            }

            if (Character.isDigit(input.charAt(0))) {
                VIP.add(input);
            } else {
                regulars.add(input);
            }
        }

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("END")) {
                break;
            }

            if (Character.isDigit(input.charAt(0))) {
                VIP.remove(input);
            } else {
                regulars.remove(input);
            }
        }

        VIP.addAll(regulars);

        System.out.println(VIP.size());

        for (String s : VIP) {
            System.out.println(s);
        }
    }
}