import Controllers.InputController;

public class Main {

    public static void main(String[] args) {
        InputController inputController = new InputController();

        inputController.getPeopleFromInput();
        inputController.printPerson();
    }
}