package creational.prototype.unclebob;

public class ShapeApplicationMain {
    static { // can init in the main
        ShapePrototypes.circlePrototype = new Circle();
        ShapePrototypes.squarePrototype = new Square();
    }

    public static void main(String[] args) throws Exception {
        ShapeApplicationUsingPrototype app = new ShapeApplicationUsingPrototype();
        app.run();
    }
}
