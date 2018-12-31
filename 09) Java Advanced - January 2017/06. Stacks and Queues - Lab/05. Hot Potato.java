import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class DecToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> kids = new ArrayDeque<>();

        Collections.addAll(kids, scanner.nextLine().split("\\s+"));
        int hotPotatoCnt = scanner.nextInt();

        while (kids.size() > 1) {
            for (int i = 1; i < hotPotatoCnt; i++) {
                String currentKid = kids.remove();
                kids.add(currentKid);
            }
            System.out.printf("Removed %s%n", kids.pop());
        }

        System.out.printf("Last is %s%n", kids.pop());
    }
}