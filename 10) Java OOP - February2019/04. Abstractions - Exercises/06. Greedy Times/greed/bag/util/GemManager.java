package greed.bag.util;

import greed.currency.Gem;

import java.util.ArrayList;

public class GemManager extends BagCurrencyManager<Gem> {

    public GemManager() {
        super(new ArrayList<>(), "Gem");
    }

    public void addCurrency(String name, long amt) {
        super.addCurrency(new Gem(name, amt));
    }
}
