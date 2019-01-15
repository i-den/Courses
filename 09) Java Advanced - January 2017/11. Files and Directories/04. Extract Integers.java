import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {

    private static final String inputFile = "enterHere";

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new FileInputStream(inputFile))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt());
                }

                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}