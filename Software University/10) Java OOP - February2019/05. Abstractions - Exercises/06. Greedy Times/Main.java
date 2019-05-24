import greed.GreedController;

public class Main {

    public static void main(String[] args) {
        GreedController greedController = new GreedController();
        greedController.createBag();
        greedController.fillBag();
        greedController.printBagContents();
    }
}
