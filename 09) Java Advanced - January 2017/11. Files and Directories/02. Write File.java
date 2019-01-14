import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class WriteToFile {

    private static final String inputFile = "enterHere";
    private static final String outputFile = "enterHere";

    public static void main(String[] args) {

        Character[] charsToSkip = {',', '.', '!', '?'};

        try (
                FileInputStream fileInpStr = new FileInputStream(inputFile);
                FileOutputStream fileOutStr = new FileOutputStream(outputFile)
        ) {
            int currByte = fileInpStr.read();

            while (currByte >= 0) {
                if (!Arrays.asList(charsToSkip).contains((char) currByte)) {
                   fileOutStr.write((char) currByte);
                }

                currByte = fileInpStr.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}