package input;

import figures.Point;
import figures.Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class InputManager {

    private Scanner scanner;

    public InputManager() {
        scanner = new Scanner(System.in);
    }

    public Rectangle createRectangleFromInput() {
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point topLeftPt = new Point(tokens[0], tokens[1]);
        Point bottomRightPt = new Point(tokens[2], tokens[3]);
        return new Rectangle(topLeftPt, bottomRightPt);
    }

    private Point createPointFromInput() {
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new Point(tokens[0], tokens[1]);
    }

    public void checkCoordsFromInput(Rectangle rectangle) {
        int coordsCnt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < coordsCnt; i++) {
            Point ptToCheck = createPointFromInput();
            System.out.println(rectangle.contains(ptToCheck));
        }
    }
}
