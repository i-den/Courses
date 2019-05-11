package greed.currency;

public class Cash extends Currency {

    public static final String REGEX_PATTERN = "(?i)[A-Za-z]{3}";


    public Cash(String name, long amount) {
        super(name, amount);
    }
}
