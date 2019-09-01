
import cards.Card;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        Card card = new Card(cardSuit, cardRank);
        System.out.println(card);
    }
}