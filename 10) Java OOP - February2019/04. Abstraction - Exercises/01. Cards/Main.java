public class Main {

    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (Cards cards : Cards.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cards.getVal(), cards);
        }
    }
}
