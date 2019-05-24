import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CopyBytes {

    private static final String INPUT_FILE = "enterHere";
    private static final String OUTPUT_FILE = "enterHere";

    public static void main(String[] args) {
        List<Character> charsToSkip = Arrays.asList(' ', '\n');

        try (
                FileInputStream fileInputStream = new FileInputStream(INPUT_FILE);
                FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE)
        ) {

            int readByte;
            while ((readByte = fileInputStream.read()) > -1) {
                if (!charsToSkip.contains((char) readByte)) {
                    String strToWrite = String.valueOf(readByte);
                    for (int i = 0; i < strToWrite.length(); i++) {
                        fileOutputStream.write(strToWrite.charAt(i));
                    }
                } else {
                    fileOutputStream.write(readByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
