public class Main {

    public static void main(String[] args) {
        CarController carController = new CarController();

        carController.getCarAmount();
        carController.createCarsFromInput();
        carController.handleInputCmds();
        carController.printCars();
    }
}