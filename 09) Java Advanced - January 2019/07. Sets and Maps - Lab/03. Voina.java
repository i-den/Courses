import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina {

    private static final int START_CARDS_AMNT = 20;
    private static final int MAX_ROUNDS = 50;
    private static final String FIRST_PLAYER_WIN_MSG = "First player win!";
    private static final String SECOND_PLAYER_WIN_MSG = "Second player win!";
    private static final String DRAW_MSG = "Draw!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayerCards = getPlayerCards(scanner);
        LinkedHashSet<Integer> secondPlayerCards = getPlayerCards(scanner);
        playVoinaRounds(firstPlayerCards, secondPlayerCards);
        printWinner(firstPlayerCards, secondPlayerCards);
    }

    private static LinkedHashSet<Integer> getPlayerCards(Scanner scanner) {
        LinkedHashSet<Integer> playerCards = new LinkedHashSet<>();
        for (int i = 0; i < START_CARDS_AMNT; i++) {
            playerCards.add(scanner.nextInt());
        }
        return playerCards;
    }

    private static void playVoinaRounds(LinkedHashSet<Integer> firstPlayerCards,
                                        LinkedHashSet<Integer> secondPlayerCards) {
        for (int i = 0; i < MAX_ROUNDS; i++) {
            Integer firstPlayerTopCard = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstPlayerTopCard);

            Integer secondPlayerTopCard = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondPlayerTopCard);

            if (firstPlayerTopCard > secondPlayerTopCard) {
                firstPlayerCards.add(firstPlayerTopCard);
                firstPlayerCards.add(secondPlayerTopCard);
            } else if (firstPlayerTopCard < secondPlayerTopCard){
                secondPlayerCards.add(firstPlayerTopCard);
                secondPlayerCards.add(secondPlayerTopCard);
            }

            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                return;
            }
        }
    }

    private static void printWinner(LinkedHashSet<Integer> firstPlayerCards, LinkedHashSet<Integer> secondPlayerCards) {
        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println(FIRST_PLAYER_WIN_MSG);
        } else if (firstPlayerCards.size() < secondPlayerCards.size()) {
            System.out.println(SECOND_PLAYER_WIN_MSG);
        } else {
            System.out.println(DRAW_MSG);
        }
    }
}