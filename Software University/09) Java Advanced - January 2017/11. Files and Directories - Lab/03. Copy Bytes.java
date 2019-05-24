import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class CopyByte {

    private static final String inputFile = "/home/vankata/sites/Test_2/input.txt";
    private static final String outputFile = "/home/vankata/sites/Test_2/output.txt";

    public static void main(String[] args) {

        Character[] plainCharsToWrite = {' ', '\n'};

        try (
                FileInputStream fileInpStr = new FileInputStream(inputFile);
                FileOutputStream fileOutStr = new FileOutputStream(outputFile)
        ) {
            int currByte = fileInpStr.read();

            while (currByte >= 0) {
                char currChar = (char) currByte;

                if (Arrays.asList(plainCharsToWrite).contains(currChar)) {
                    fileOutStr.write(currChar);
                } else {
                    String currASCI = String.valueOf(currByte);

                    for (int i = 0; i < currASCI.length(); i++) {
                        fileOutStr.write(currASCI.charAt(i));
                    }
                }

                currByte = fileInpStr.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}