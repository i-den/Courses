package money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(6));
        assertNotEquals(Money.franc(5), Money.dollar(5));
    }

    @Test
    public void testMoneyEquality() {
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    public void testSimpleAddition() {
        Expression sum= new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank= new Bank();
        Money result= bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank= new Bank();
        Money result= bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result= bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition() {
        Expression fiveBucks= Money.dollar(5);
        Expression tenFrancs= Money.franc(10);
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result= bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testSumPlusMoney() {
        Expression fiveBucks= Money.dollar(5);
        Expression tenFrancs= Money.franc(10);
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum= new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result= bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes() {
        Expression fiveBucks= Money.dollar(5);
        Expression tenFrancs= Money.franc(10);
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum= new Sum(fiveBucks, tenFrancs).times(2);
        Money result= bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }

    @Test
    public void testPlusSameCurrencyReturnsMoney() {
        Expression sum= Money.dollar(1).plus(Money.dollar(1));
        assertTrue(sum instanceof Money);
    }
}