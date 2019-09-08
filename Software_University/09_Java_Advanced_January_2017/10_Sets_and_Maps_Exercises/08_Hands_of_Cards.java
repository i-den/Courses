import java.util.*;

public class HandsOfCards {

    private final static HashMap<String, Integer> cardPowerMap = new HashMap<String, Integer>() {
        {
            put("J", 11);
            put("Q", 12);
            put("K", 13);
            put("A", 14);
        }
    };

    private final static HashMap<String, Integer> cardTypeMap = new HashMap<String, Integer>() {
        {
            put("S", 4);
            put("H", 3);
            put("D", 2);
            put("C", 1);
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> playerCards = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> playerScores = new LinkedHashMap<>();

        while (true) {
            String[] playerCardTokens = scanner.nextLine()
                    .split(":");

            if (playerCardTokens[0].equals("JOKER")) {
                break;
            }

            String currPlayer = playerCardTokens[0];
            String[] currCards = playerCardTokens[1].split("(\\s|,)+");

            if (!playerCards.containsKey(currPlayer)) {
                playerCards.put(currPlayer, new HashSet<>());
            }

            playerCards.get(currPlayer)
                    .addAll(Arrays.asList(currCards));
        }

        for (String currPlayerName : playerCards.keySet()) {
            if (!playerScores.containsKey(currPlayerName)) {
                playerScores.put(currPlayerName, 0);
            }

            playerScores.put(
                    currPlayerName,
                    playerScores.get(currPlayerName) + getPlayerScore(playerCards.get(currPlayerName))
            );
        }

        for (String currPlayerName : playerScores.keySet()) {
            System.out.println(currPlayerName + ": " + playerScores.get(currPlayerName));
        }
    }

    private static int getPlayerScore(HashSet<String> playerCards) {
        int score = 0;
        for (String currentCard : playerCards) {
            if (currentCard.equals("")) {
                continue;
            }

            int cardPow = getCardPower(currentCard.substring(0, currentCard.length() - 1));
            int cardTypeMultiplier = cardTypeMap.get(currentCard.substring(currentCard.length() - 1));

            score += cardPow * cardTypeMultiplier;
        }

        return score;
    }

    private static int getCardPower(String cardPow) {
        for (char currChar : cardPow.toCharArray()) {
            if (!Character.isDigit(currChar)) {
                return cardPowerMap.get(cardPow);
            }
        }

        return Integer.parseInt(cardPow);
    }
}