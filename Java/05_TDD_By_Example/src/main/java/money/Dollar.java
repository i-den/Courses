package money;

public class Dollar extends Money {

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }
}
