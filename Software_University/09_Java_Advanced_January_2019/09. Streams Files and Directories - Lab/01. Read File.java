import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    private final static String INPUT_FILE = "inputHere";

    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream(INPUT_FILE)) {
            int readByte;
            while ((readByte = fileInputStream.read()) > -1) {
                System.out.printf("%s ", Integer.toBinaryString(readByte));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}