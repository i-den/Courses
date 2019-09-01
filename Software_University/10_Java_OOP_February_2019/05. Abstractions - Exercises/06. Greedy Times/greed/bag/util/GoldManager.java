package greed.bag.util;

import greed.currency.Gold;

import java.util.ArrayList;

public class GoldManager extends BagCurrencyManager<Gold> {

    public GoldManager() {
        super(new ArrayList<>(), "Gold");
    }

    public void addCurrency(String name, long amt) {
        super.addCurrency(new Gold(name, amt));
    }
}
