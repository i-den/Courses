package greed;

import greed.bag.Bag;
import greed.currency.Cash;
import greed.currency.Gem;
import greed.currency.Gold;

import java.util.Scanner;

public class GreedController {

    private Bag bag;

    private Scanner scanner;

    public GreedController() {
        scanner = new Scanner(System.in);
    }

    public void createBag() {
        long bagCapacityFromInput = Long.parseLong(scanner.nextLine());
        bag = new Bag(bagCapacityFromInput);
    }

    public void fillBag() {
        String[] bagTokensToFill = scanner.nextLine().split("\\s+");
        for (int i = 0; i < bagTokensToFill.length; i += 2) {
            String currencyName = bagTokensToFill[i];
            long currencyValue = Long.parseLong(bagTokensToFill[i+1]);

            if (currencyName.matches(Cash.REGEX_PATTERN)) {
                bag.addCash(currencyName, currencyValue);
            } else if (currencyName.matches(Gem.REGEX_PATTERN)) {
                bag.addGem(currencyName, currencyValue);
            } else if (currencyName.matches(Gold.REGEX_PATTERN)) {
                bag.addGold(currencyName, currencyValue);
            }
        }
    }

    public void printBagContents() {
        System.out.println(bag);
    }
}
