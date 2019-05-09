import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rhombQuantifier = Integer.parseInt(scanner.nextLine());
        Rhombus rhombus = new Rhombus(rhombQuantifier);
        rhombus.draw();
    }
}

