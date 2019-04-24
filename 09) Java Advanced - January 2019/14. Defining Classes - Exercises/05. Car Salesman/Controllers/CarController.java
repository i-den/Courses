package Controllers;

import Car.Car;
import Car.Parts.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarController {

    private Scanner scanner;

    private List<Car> cars;

    private List<Engine> engines;

    private int engineAmnt;

    private int carAmnt;

    public CarController() {
        scanner = new Scanner(System.in);
        cars = new ArrayList<>();
        engines = new ArrayList<>();
    }

    public void getEngineAmntFromInput() {
        engineAmnt = Integer.parseInt(scanner.nextLine());
    }

    public void getCarAmntFromInput() {
        carAmnt = Integer.parseInt(scanner.nextLine());
    }

    public void createEnginesFromInput() {
        for (int i = 0; i < engineAmnt; i++) {
            String[] engineTokens = scanner.nextLine().split("\\s+");
            Engine engine = new Engine(engineTokens[0], Integer.parseInt(engineTokens[1]));

            for (int j = 2; j < engineTokens.length; j++) {
                if (isNumber(engineTokens[j])) {
                    engine.setDisplacement(Integer.parseInt(engineTokens[j]));
                } else {
                    engine.setEfficiency(engineTokens[j]);
                }
            }

            engines.add(engine);
        }
    }


    public void createCarsFromInput() {
        for (int i = 0; i < carAmnt; i++) {
            String[] carTokens = scanner.nextLine().split("\\s+");
            Car car = new Car(carTokens[0], findEngineByModel(carTokens[1]));

            if (carTokens.length > 2) {
                for (int j = 2; j < carTokens.length; j++) {
                    if (isNumber(carTokens[j])) {
                        car.setWeight(Integer.parseInt(carTokens[j]));
                    } else {
                        car.setColor(carTokens[j]);
                    }
                }
            }

            cars.add(car);
        }
    }

    private Engine findEngineByModel(String model) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(model)) {
                return engine;
            }
        }
        return null;
    }

    private boolean isNumber(String numToTest) {
        return numToTest.matches("([+\\-])?[0-9]+(.[0-9]+)?");
    }
}
