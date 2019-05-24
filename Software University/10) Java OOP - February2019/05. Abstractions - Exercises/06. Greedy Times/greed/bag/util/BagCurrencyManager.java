package greed.bag.util;

import greed.currency.Currency;

import java.util.List;

public abstract class BagCurrencyManager<T extends Currency> {

    private List<Currency> currencyList;

    private long totalValue;

    private String name;

    BagCurrencyManager(List<Currency> currencyList, String name) {
        this.currencyList = currencyList;
        totalValue = 0L;
        this.name = name;
    }

    public void addCurrencyValue(long amt) {
        this.totalValue += amt;
    }

    public long getTotalValue() {
        return this.totalValue;
    }

    void addCurrency(T currencyToAdd) {
        Currency currencyFromList = findCurrencyByName(currencyToAdd.getName());
        if (currencyFromList == null) {
            currencyList.add(currencyToAdd);
        } else {
            currencyFromList.addAmount(currencyToAdd.getAmount());
        }
        totalValue += currencyToAdd.getAmount();
    }

    private Currency findCurrencyByName(String name) {
        for (Currency currency : currencyList) {
            if (currency.getName().equals(name))
                return currency;
        }
        return null;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public String getName() {
        return name;
    }
}
