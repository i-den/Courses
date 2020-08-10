package creational.factory.method.abscreator;

import creational.factory.method.abscreator.factory.AbstractShapeFactory;
import creational.factory.method.abscreator.factory.CircleFactory;
import creational.factory.method.abscreator.factory.SquareFactory;

public class Main {

    public static void main(String[] args) {
        AbstractShapeFactory shapeFactory;

        shapeFactory= new CircleFactory();
        shapeFactory.getShape().draw();

        shapeFactory = new SquareFactory();
        shapeFactory.getShape().draw();
    }
}
