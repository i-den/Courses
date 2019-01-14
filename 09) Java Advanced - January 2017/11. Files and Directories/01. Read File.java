import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    private static final String inputFile = "enterHere";

    public static void main(String[] args) {

        try (FileInputStream fileInpStr = new FileInputStream(inputFile)) {
            int currByte = fileInpStr.read();

            while (currByte >= 0) {
                System.out.print(Integer.toBinaryString(currByte) + ' ');
                currByte = fileInpStr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}