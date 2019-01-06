import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina {

    private static int roundCnt = 50;
    private static int startCardsCnt = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayerCards = new LinkedHashSet<>();
        LinkedHashSet<Integer> secPlayerCards = new LinkedHashSet<>();

        for (int i = 0; i < startCardsCnt; i++) {
            firstPlayerCards.add(scanner.nextInt());
        }

        for (int i = 0; i < startCardsCnt; i++) {
            secPlayerCards.add(scanner.nextInt());
        }

        for (int i = 0; i < roundCnt; i++) {
            int firstPlayerTopCard = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstPlayerTopCard);

            int secPlayerTopCard = secPlayerCards.iterator().next();
            secPlayerCards.remove(secPlayerTopCard);

            if (firstPlayerTopCard > secPlayerTopCard) {
                firstPlayerCards.add(firstPlayerTopCard);
                firstPlayerCards.add(secPlayerTopCard);
            }

            if (firstPlayerTopCard < secPlayerTopCard) {
                secPlayerCards.add(firstPlayerTopCard);
                secPlayerCards.add(secPlayerTopCard);
            }

            if (firstPlayerCards.isEmpty() || secPlayerCards.isEmpty()) {
                break;
            }
        }

        if (firstPlayerCards.size() > secPlayerCards.size()) {
            System.out.println("First player win!");
        }

        if (firstPlayerCards.size() < secPlayerCards.size()) {
            System.out.println("Second player win!");
        }

        if (firstPlayerCards.size() == secPlayerCards.size()) {
            System.out.println("Draw!");
        }
    }
}