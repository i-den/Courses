package creational.factory.method.abscreator.factory;

import creational.factory.method.abscreator.shape.Shape;
import creational.factory.method.abscreator.shape.Square;

public class SquareFactory extends AbstractShapeFactory {
    @Override
    protected Shape factoryMethod() {
        return new Square();
    }
}
