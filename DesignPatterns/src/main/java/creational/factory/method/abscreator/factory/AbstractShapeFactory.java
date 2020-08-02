package creational.factory.method.abscreator.factory;

import creational.factory.method.abscreator.shape.Shape;

public abstract class AbstractShapeFactory {
    protected abstract Shape factoryMethod();

    public Shape getShape() {
        return factoryMethod();
    }
}
