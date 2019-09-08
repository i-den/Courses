import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {

    private static final String INPUT_FILE = "inputHere";
    private static final String OUTPUT_FILE = "inputHere";

    public static void main(String[] args) {
        List<Character> disallowedCharacters = Arrays.asList(',', '.', '!', '?');

        try (FileInputStream fileInputStream = new FileInputStream(INPUT_FILE);
             FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE)
        ) {
            int readByte;
            while ((readByte = fileInputStream.read()) > -1) {
                if (!disallowedCharacters.contains((char) readByte)) {
                    fileOutputStream.write(readByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}