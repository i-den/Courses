package creational.factory.abs.diveintodspt.furniture.factory;

import creational.factory.abs.diveintodspt.furniture.Chair;
import creational.factory.abs.diveintodspt.furniture.CoffeeTable;
import creational.factory.abs.diveintodspt.furniture.VictorianChair;
import creational.factory.abs.diveintodspt.furniture.VictorianCoffeeTable;

public class VictorianFurnitureFactory implements AbstractFurnitureFactory {
    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }
}
