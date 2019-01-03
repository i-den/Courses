import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> kids = new ArrayDeque<>();

        Collections.addAll(kids, scanner.nextLine().split("\\s+"));
        int hotPotatoCnt = scanner.nextInt();
        int primeCycleCnt = 1;

        while (kids.size() > 1) {
            for (int i = 1; i < hotPotatoCnt; i++) {
                String currentKid = kids.remove();
                kids.add(currentKid);
            }

            if (isPrime(primeCycleCnt)) {
                System.out.printf("Prime %s%n", kids.peek());
            } else {
                System.out.printf("Removed %s%n", kids.pop());
            }

            primeCycleCnt++;
        }

        System.out.printf("Last is %s%n", kids.pop());
    }

    private static boolean isPrime(int numToCheck) {
        if (numToCheck < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numToCheck); i++) {
            if (numToCheck % i == 0) {
                return false;
            }
        }

        return true;
    }
}