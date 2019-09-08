import figures.Rectangle;
import input.InputManager;

public class Main {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        Rectangle rectangle = inputManager.createRectangleFromInput();
        inputManager.checkCoordsFromInput(rectangle);
    }
}

