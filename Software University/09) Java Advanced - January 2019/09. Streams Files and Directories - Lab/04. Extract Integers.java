import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {

    private static final String INPUT_FILE = "enterHere";
    private static final String OUTPUT_FILE = "enterHere";

    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(new FileInputStream(INPUT_FILE));
                FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE)
        ) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    String nextIntAsStr = String.valueOf(scanner.nextInt());
                    for (int i = 0; i < nextIntAsStr.length(); i++) {
                        fileOutputStream.write(nextIntAsStr.charAt(i));
                    }
                    fileOutputStream.write('\n');
                }
                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
