package greed.currency;

public class Gold extends Currency {

    public static final String REGEX_PATTERN = "(?i)\\bGold\\b";

    public static final String DEFAULT_NAME = "Gold";

    public Gold(String name, long amount) {
        super(name, amount);
    }
}