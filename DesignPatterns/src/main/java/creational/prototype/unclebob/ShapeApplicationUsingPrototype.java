package creational.prototype.unclebob;

public class ShapeApplicationUsingPrototype {
    public void run() throws Exception {
        Shape circle = (Shape) ShapePrototypes.circlePrototype.clone();
        // ((Circle) circle).doStuff();
    }
}
