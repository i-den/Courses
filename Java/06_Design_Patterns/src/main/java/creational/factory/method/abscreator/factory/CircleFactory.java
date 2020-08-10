package creational.factory.method.abscreator.factory;

import creational.factory.method.abscreator.shape.Circle;
import creational.factory.method.abscreator.shape.Shape;

public class CircleFactory extends AbstractShapeFactory {
    @Override
    protected Shape factoryMethod() {
        return new Circle();
    }
}
