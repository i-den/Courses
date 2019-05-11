package greed.bag;

import greed.bag.util.BagCurrencyManager;
import greed.bag.util.CashManager;
import greed.bag.util.GemManager;
import greed.bag.util.GoldManager;
import greed.currency.Currency;
import greed.currency.Gold;

import java.util.LinkedList;
import java.util.List;

public class Bag {

    private long capacity;

    private CashManager cashManager;
    private GemManager gemManager;
    private GoldManager goldManager;

    private List<BagCurrencyManager> bagCurrencyManagers;

    public Bag(long capacity) {
        this.capacity = capacity;
        cashManager = new CashManager();
        goldManager = new GoldManager();
        gemManager = new GemManager();
        bagCurrencyManagers = new LinkedList<>();
    }

    public void addCash(String name, long amt) {
        if (!bagCurrencyManagers.contains(cashManager)) {
            bagCurrencyManagers.add(cashManager);
        }
        long totalCashValueAfterAdding = cashManager.getTotalValue() + amt;
        long totalBagValueAfterAdding = getTotalValue() + amt;
        if (totalCashValueAfterAdding <= gemManager.getTotalValue()
                && totalBagValueAfterAdding <= capacity) {
            cashManager.addCurrency(name, amt);
        }
    }

    public void addGem(String name, long amt) {
        if (!bagCurrencyManagers.contains(gemManager)) {
            bagCurrencyManagers.add(gemManager);
        }
        long totalBagValueAfterAdding = getTotalValue() + amt;
        long totalGemValueAfterAdding = gemManager.getTotalValue() + amt;
        if (totalGemValueAfterAdding <= goldManager.getTotalValue()
                && totalBagValueAfterAdding <= capacity) {
            gemManager.addCurrency(name, amt);
        }
    }

    public void addGold(String name, long amt) {
        if (!bagCurrencyManagers.contains(goldManager)) {
            bagCurrencyManagers.add(goldManager);
        }
        long totalBagValueAfterAdding = getTotalValue() + amt;
        if (totalBagValueAfterAdding <= capacity) {
            goldManager.addCurrency(Gold.DEFAULT_NAME, amt);
        }
    }

    private long getTotalValue() {
        return cashManager.getTotalValue() + gemManager.getTotalValue() + goldManager.getTotalValue();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        bagCurrencyManagers.stream()
                .sorted((m1, m2) -> Long.compare(m2.getTotalValue(), m1.getTotalValue()))
                .filter(m -> !m.getCurrencyList().isEmpty())
                .forEach(m -> {
                    List<Currency> currencyList = m.getCurrencyList();
                    stringBuilder.append(String.format("<%s> $%d%n", m.getName(), m.getTotalValue()));
                    currencyList.stream()
                            .sorted(Currency::compareTo)
                            .forEach(c -> stringBuilder.append(c.toString()));
                });
        return stringBuilder.toString();
    }
}
