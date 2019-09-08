import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class CarController {

    private static final String CMD_DRIVE = "Drive";

    private static final String CMD_TO_STOP_INPUT = "End";

    private Scanner scanner;

    private Integer carAmount;

    private List<Car> cars;

    CarController() {
        scanner = new Scanner(System.in);
        cars = new LinkedList<>();
    }

    void getCarAmount() {
        carAmount = Integer.parseInt(scanner.nextLine());
    }

    void createCarsFromInput() {
        if (carAmount == null) {
            throw new NullPointerException("The Car Amount isn't specified.");
        }

        for (int i = 0; i < carAmount; i++) {
            String[] carTokens = scanner.nextLine().split("\\s+");
            cars.add(new Car(
                    carTokens[0],
                    Double.parseDouble(carTokens[1]),
                    Double.parseDouble(carTokens[2])
            ));
        }
    }


    void handleInputCmds() {
        String fullCmd;
        while (!(fullCmd = scanner.nextLine()).equals(CMD_TO_STOP_INPUT)) {
            String[] cmdTokens = fullCmd.split("\\s+");

            switch (cmdTokens[0]) {
                case CMD_DRIVE:
                default:
                    attemptToDriveCar(cmdTokens[1], Integer.parseInt(cmdTokens[2]));
                    break;
            }
        }
    }

    private void attemptToDriveCar(String model, Integer distance) {
        Car carToDrive = findCarInListByModel(model);
        if (carToDrive == null) {
            throw new NullPointerException("No Car found with the model " + model);
        }

        if (carToDrive.hasFuelToDriveDistance(distance)) {
            carToDrive.travelDistance(distance);
        } else {
            System.out.println(Car.NO_FUEL_ERR_MSG);
        }
    }

    private Car findCarInListByModel(String model) {
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    void printCars() {
        for (Car car : cars) {
            System.out.println(car.getInfo());
        }
    }
}
