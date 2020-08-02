package creational.factory.abs.diveintodspt;

import creational.factory.abs.diveintodspt.furniture.Chair;
import creational.factory.abs.diveintodspt.furniture.CoffeeTable;
import creational.factory.abs.diveintodspt.furniture.factory.AbstractFurnitureFactory;

public class App {

    private AbstractFurnitureFactory furnitureFactory;

    App(AbstractFurnitureFactory furnitureFactory) {
        this.furnitureFactory = furnitureFactory;
    }

    void doStuff() {
        Chair chair = furnitureFactory.createChair();
        CoffeeTable coffeeTable = furnitureFactory.createCoffeeTable();

        chair.sitOn();
        // ...
    }
}
