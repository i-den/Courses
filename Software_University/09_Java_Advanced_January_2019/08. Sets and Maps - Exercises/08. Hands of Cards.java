import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandsOfCards {

    private static final String STR_TO_END_INPUT = "JOKER";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> playersCardHand = new LinkedHashMap<>();

        String input;
        while (!STR_TO_END_INPUT.equals((input = scanner.nextLine()))) {
            String[] playerCardsTokens = input.split(":");
            String[] cards = playerCardsTokens[1].trim().split("[\\s,]+");

            playersCardHand.putIfAbsent(playerCardsTokens[0], new HashSet<>());
            Collections.addAll(
                    playersCardHand.get(playerCardsTokens[0]),
                    cards
            );
        }

        for (String player : playersCardHand.keySet()) {
            System.out.printf("%s: %d%s", player, getPlayerHandPower(playersCardHand.get(player)), System.lineSeparator());
        }
    }

    private static Integer getPlayerHandPower(HashSet<String> cards) {
        int cardSum = 0;
        for (String card : cards) {
            cardSum += getCardPower(card);
        }
        return cardSum;
    }

    private static int getCardPower(String card) {
        Pattern cardPowerRegEx = Pattern.compile("(?<cardPower>([\\d]{1,2}|[JQKA]))(?<cardMultiplier>[SHDC])");
        Matcher cardPowerMatcher = cardPowerRegEx.matcher(card);

        cardPowerMatcher.find();
        String cardPowerStr = cardPowerMatcher.group("cardPower");
        String cardPowerMultiplierStr = cardPowerMatcher.group("cardMultiplier");

        int cardPower;
        switch (cardPowerStr) {
            case "J":
                cardPower = 11;
                break;
            case "Q":
                cardPower = 12;
                break;
            case "K":
                cardPower = 13;
                break;
            case "A":
                cardPower = 14;
                break;
            default:
                cardPower = Integer.parseInt(cardPowerStr);
        }

        int cardMultiplier;
        switch (cardPowerMultiplierStr) {
            case "S":
                cardMultiplier = 4;
                break;
            case "H":
                cardMultiplier = 3;
                break;
            case "D":
                cardMultiplier = 2;
                break;
            case "C":
            default:
                cardMultiplier = 1;
        }

        return cardPower * cardMultiplier;
    }
}