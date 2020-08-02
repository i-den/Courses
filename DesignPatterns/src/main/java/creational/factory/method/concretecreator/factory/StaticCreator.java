package creational.factory.method.concretecreator.factory;

import creational.factory.method.concretecreator.shape.Circle;
import creational.factory.method.concretecreator.shape.Shape;
import creational.factory.method.concretecreator.shape.Square;

public class StaticCreator {
    public static Shape getShape(String type) {
        if (type == null)
            return null;

        switch (type) {
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            default: throw new IllegalArgumentException();
        }
    }
}
