package Car;

import Car.Parts.Engine;

public class Car {

    private static final String NOT_DEF_PRINT_VAL = "n/a";

    private String model;

    private Engine engine;

    private int weight;

    private String color;


    public Car(String model, Engine engine) {
        setModel(model);
        setEngine(engine);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        setWeight(weight);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        setColor(color);
    }

    @Override
    public String toString() {
        return String.format(
                "%s:%n%s%nWeight: %s%nColor: %s",
                getModel(),
                getEngine().toString(),
                getWeight() == 0 ? NOT_DEF_PRINT_VAL : getWeight(),
                getColor() == null ? NOT_DEF_PRINT_VAL : getColor()
        );
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
