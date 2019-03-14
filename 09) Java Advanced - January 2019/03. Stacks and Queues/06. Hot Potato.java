import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {

    private final static String REMOVED_PLAYER = "Removed";
    private final static String LAST_PLAYER = "Last is";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> playerNames = new ArrayDeque<>();

        Collections.addAll(playerNames, scanner.nextLine().split("\\s+"));
        int nThPlayerToRemove = scanner.nextInt();

        while (playerNames.size() != 1) {
            for (int i = 1; i < nThPlayerToRemove; i++) {
                playerNames.addLast(playerNames.removeFirst());
            }
            System.out.println(String.format("%s %s", REMOVED_PLAYER, playerNames.removeFirst()));
        }

        System.out.println(String.format("%s %s", LAST_PLAYER, playerNames.removeFirst()));
    }
}