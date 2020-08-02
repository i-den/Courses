package creational.factory.abs.diveintodspt.furniture.factory;

import creational.factory.abs.diveintodspt.furniture.Chair;
import creational.factory.abs.diveintodspt.furniture.CoffeeTable;
import creational.factory.abs.diveintodspt.furniture.ModernChair;
import creational.factory.abs.diveintodspt.furniture.ModernCoffeeTable;

public class ModernFurnitureFactory implements AbstractFurnitureFactory {
    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }

    @Override
    public Chair createChair() {
        return new ModernChair();
    }
}
