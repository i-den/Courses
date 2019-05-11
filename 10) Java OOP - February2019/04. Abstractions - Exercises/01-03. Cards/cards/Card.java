package cards;

public class Card {

    private CardSuit cardSuit;

    private CardRank cardRank;

    public Card(String cardSuit, String cardRank) {
        this.cardSuit = CardSuit.valueOf(cardSuit);
        this.cardRank = CardRank.valueOf(cardRank);
    }

    @Override
    public String toString() {
        return String.format(
                "Card name: %s of %s; Card power: %d",
                cardRank,
                cardSuit,
                cardRank.getValue() + cardSuit.getValue()
        );
    }
}
