import Controllers.CarController;

public class Main {

    public static void main(String[] args) {
        CarController carController = new CarController();

        carController.getEngineAmntFromInput();
        carController.getCarAmntFromInput();

        carController.createEnginesFromInput();
        carController.createCarsFromInput();

        
    }
}
