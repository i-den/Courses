package greed.bag.util;

import greed.currency.Cash;

import java.util.ArrayList;

public class CashManager extends BagCurrencyManager<Cash> {

    public CashManager() {
        super(new ArrayList<>(), "Cash");
    }

    public void addCurrency(String name, long amt) {
        super.addCurrency(new Cash(name, amt));
    }
}
