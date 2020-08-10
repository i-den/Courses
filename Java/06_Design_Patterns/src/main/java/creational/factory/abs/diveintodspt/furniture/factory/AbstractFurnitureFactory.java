package creational.factory.abs.diveintodspt.furniture.factory;

import creational.factory.abs.diveintodspt.furniture.Chair;
import creational.factory.abs.diveintodspt.furniture.CoffeeTable;

public interface AbstractFurnitureFactory {

    CoffeeTable createCoffeeTable();

    Chair createChair();
}
