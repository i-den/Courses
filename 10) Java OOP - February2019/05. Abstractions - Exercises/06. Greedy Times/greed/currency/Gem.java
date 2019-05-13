package greed.currency;

public class Gem extends Currency {

    public static final String REGEX_PATTERN = "(?i)\\b[\\w]+gem\\b";

    public Gem(String name, long amount) {
        super(name, amount);
    }

}
