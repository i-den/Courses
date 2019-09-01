import java.io.*;

public class AllCapitals {

    private static final String inputFile = "enterHere";
    private static final String outputFile = "enterHere";

    public static void main(String[] args) {

        try (
                FileInputStream fileInputStream = new FileInputStream(inputFile);
                FileOutputStream fileOutputStream = new FileOutputStream(outputFile)
        ) {
            int currByte = fileInputStream.read();

            while (currByte >= 0) {
                fileOutputStream.write(Character.toUpperCase(currByte));

                currByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}