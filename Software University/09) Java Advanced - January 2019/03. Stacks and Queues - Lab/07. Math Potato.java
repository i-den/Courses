import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {

    private final static String REMOVED_PLAYER = "Removed";
    private final static String LAST_PLAYER = "Last is";
    private final static String PRIME_CYCLE_PLAYER = "Prime";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> playerNames = new ArrayDeque<>();

        Collections.addAll(playerNames, scanner.nextLine().split("\\s+"));
        int nThPlayerToRemove = scanner.nextInt();

        int currCycle = 1;
        while (playerNames.size() > 1) {
            for (int i = 1; i < nThPlayerToRemove; i++) {
                playerNames.addLast(playerNames.removeFirst());
            }
            if (!isPrime(currCycle)) {
                System.out.println(String.format("%s %s", REMOVED_PLAYER, playerNames.removeFirst()));
            } else {
                System.out.println(String.format("%s %s", PRIME_CYCLE_PLAYER, playerNames.peekFirst()));
            }
            currCycle++;
        }

        System.out.println(String.format("%s %s", LAST_PLAYER, playerNames.removeFirst()));
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