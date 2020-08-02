package creational.factory.method.concretecreator;

import creational.factory.method.concretecreator.factory.ShapeFactory;
import creational.factory.method.concretecreator.shape.Shape;

public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape = shapeFactory.getShape("circle");
        shape.draw();

        shape = shapeFactory.getShape("square");
        shape.draw();
    }
}
