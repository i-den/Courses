package money;

public interface Expression {

    Expression plus(Expression addend);

    Expression times(int multiplier);

    Money reduce(String to);

    Money reduce(Bank bank, String to);
}
